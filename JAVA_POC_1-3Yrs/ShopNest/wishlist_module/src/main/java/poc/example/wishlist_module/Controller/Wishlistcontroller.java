package poc.example.wishlist_module.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.example.wishlist_module.entity.Product;
import poc.example.wishlist_module.entity.User;
import poc.example.wishlist_module.entity.WishListResponse;
import poc.example.wishlist_module.entity.Wishlist;
import poc.example.wishlist_module.service.Wishlistservice;

@RestController
@RequestMapping("/wishlist")
public class Wishlistcontroller {
	
	@Autowired
	private Wishlistservice wishlistservice;
	
	@PostMapping("/addproduct")
	public WishListResponse addwishlist(@RequestBody Wishlist product) {
		System.out.println("inside add api");
		return wishlistservice.addProduct(product);
	}
	
	@GetMapping("/product/{wishlistId}")
	public ResponseEntity<WishListResponse> getProductById(@PathVariable Long wishlistId) {
	    WishListResponse productById = wishlistservice.getProductById(wishlistId);
	    System.out.println("product is" +productById);
	    return ResponseEntity.ok(productById);
	}
	
	@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
		System.out.println("user is "+user);
        User loggedInUser = wishlistservice.checkLogin(user);
        
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        	//return ResponseEntity.ok(new User());
        }
    }

	
    @GetMapping("/getallproducts")
    public List<Product> getAllProducts(){
    	return wishlistservice.getAllProducts();
   }
    
    @DeleteMapping("/product/{wishlistId}")
    public void deletefromWishlist(@PathVariable Long wishlistId){
    	wishlistservice.deleteFromWishlist(wishlistId);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
    	wishlistservice.doLogout();
    	return ResponseEntity.ok("User logged out successfully");
    }
	
 }
	
	
	
