package poc.example.wishlist_module.global_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotAvailableException.class)
	public ResponseEntity<ErrorMessage> handleProductNotAvailableException(ProductNotAvailableException ex){
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

}
