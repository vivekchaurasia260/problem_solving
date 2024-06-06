package poc.example.wishlist_module.service;



import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import poc.example.wishlist_module.entity.User;

@FeignClient(url="http://localhost:9091",value="User-module")
public interface UserClient {

	@PostMapping("/api/users/login")
    public User loginUser(@RequestBody User user);
}
