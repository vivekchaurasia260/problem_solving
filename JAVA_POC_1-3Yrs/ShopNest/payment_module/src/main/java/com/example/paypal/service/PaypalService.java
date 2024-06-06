package com.example.paypal.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.paypal.config.CouponServiceClient;
import com.example.paypal.model.CompletedOrder;
import com.example.paypal.model.PaymentOrder;
import com.example.paypal.repository.PaymentRepository;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCaptureRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;

@Service
public class PaypalService {
	
	@Value("${url}")
	private String url;

    @Autowired
    private PayPalHttpClient payPalHttpClient;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CouponServiceClient couponServiceClient;
    
    
    public PaymentOrder createPayment(Double amount, String coupon,Long userId) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");
        AmountWithBreakdown amountBreakdown = new AmountWithBreakdown().currencyCode("USD").value(amount.toString());
        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest().amountWithBreakdown(amountBreakdown);
        List<PurchaseUnitRequest> purchaseUnitRequests = Arrays.asList(purchaseUnitRequest);
        orderRequest.purchaseUnits(purchaseUnitRequests);

        if (coupon != null) {
            ApplicationContext applicationContext = new ApplicationContext()
                    .returnUrl(url+"/capture/"+userId+"/" + coupon)
                    .cancelUrl(url+"/cancel");
            orderRequest.applicationContext(applicationContext);

        } else {
            ApplicationContext applicationContext = new ApplicationContext()
                    .returnUrl(url+"/capture/"+userId )
                    .cancelUrl(url+"/cancel");
            orderRequest.applicationContext(applicationContext);

        }
        OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest().requestBody(orderRequest);

        try {
            HttpResponse<Order> orderHttpResponse = payPalHttpClient.execute(ordersCreateRequest);
            Order order = orderHttpResponse.result();

            String redirectUrl = order.links().stream()
                    .filter(link -> "approve".equals(link.rel()))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new)
                    .href();

            return new PaymentOrder("success", order.id(),userId, redirectUrl);
        } catch (IOException e) {

            return new PaymentOrder("Error");
        }
    }

    public CompletedOrder completePayment(String token, String coupon,Long userId) {
        OrdersCaptureRequest ordersCaptureRequest = new OrdersCaptureRequest(token);
        try {
            HttpResponse<Order> httpResponse = payPalHttpClient.execute(ordersCaptureRequest);
            if (httpResponse.result().status() != null) {
                CompletedOrder completedOrder = new CompletedOrder("success", token, coupon,userId);
                if (coupon != null) {
                    couponServiceClient.updateCouponByCode(coupon, true);
                    return paymentRepository.save(completedOrder);
                } else {
                    return paymentRepository.save(completedOrder);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CompletedOrder completedOrder = new CompletedOrder("error", token,coupon,userId);
        return completedOrder;
    }

}
