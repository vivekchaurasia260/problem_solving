package poc.example.wishlist_module.global_exception;

public class ProductNotAvailableException extends RuntimeException {
	public ProductNotAvailableException(String message) {
		super(message);
	}

}
