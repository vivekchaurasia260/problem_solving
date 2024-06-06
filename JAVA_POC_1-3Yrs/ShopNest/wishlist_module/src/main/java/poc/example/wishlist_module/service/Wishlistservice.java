package poc.example.wishlist_module.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import poc.example.wishlist_module.Repository.Wishlistrepo;
import poc.example.wishlist_module.entity.Product;
import poc.example.wishlist_module.entity.User;
import poc.example.wishlist_module.entity.WishListResponse;
import poc.example.wishlist_module.entity.Wishlist;
import poc.example.wishlist_module.global_exception.ProductNotAvailableException;

@Service
@Transactional
public class Wishlistservice {
	
	@Autowired
	private Wishlistrepo wishlistrepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private APIClient apiClient;
	@Autowired
	private UserClient userClient;
	boolean isLoggedIn = false;
	Long userId = -1L;
	
	public User checkLogin(User user) {
        User loginUser = userClient.loginUser(user);
        isLoggedIn = loginUser.isLoggedIn();
        userId = loginUser.getId();
        return loginUser;
    }
	
	public WishListResponse addProduct(Wishlist wishList) {
		System.out.println("isLogged in "+isLoggedIn);
		
		if(!isLoggedIn) {
			throw new ProductNotAvailableException("User is not logged in");
		}
	    List<Product> allProducts = apiClient.getAllProducts();
	    
	    Product product = allProducts.stream().filter(p->p.getId()==wishList.getpId()).findAny().orElse(null);
		if(product == null) {
			throw new ProductNotAvailableException("Product is not availabe in the list");
		} 
		wishList.setUserId(userId);
		wishlistrepo.save(wishList);
		WishListResponse wishListResponse = new WishListResponse(wishList, product);
		return wishListResponse;
		
	}	
	public void doLogout() {
		isLoggedIn = false;
		userId = -1L;
	}
	
	public WishListResponse getProductById(Long wishListId) {
		Wishlist findById = wishlistrepo.findById(wishListId).orElse(null);
		System.out.println("findById is "+findById);
		if(findById == null) {
			throw new ProductNotAvailableException("WishList id is not present");
		}	
		ResponseEntity<Product> productEntity = restTemplate.getForEntity("http://localhost:8082/api/product/getid/" +findById.getpId(), Product.class);
		Product product = productEntity.getBody();
		WishListResponse wishListResponse = new WishListResponse(findById, product);
		return wishListResponse;
   }                                               

	public List<Product> getAllProducts() {
		List<Wishlist> allWishList = wishlistrepo.findAll();
		List<Product> productList = new ArrayList<Product>();
		for(Wishlist allList:allWishList) {
			Product product = restTemplate.getForEntity("http://localhost:8082/api/product/getid/"+allList.getpId(), Product.class).getBody();
			productList.add(product);
	 }
	        return productList;
		
  }

	public void deleteFromWishlist(Long wishlistId) {
		wishlistrepo.deleteById(wishlistId);
		
	}
	
}


	
 

