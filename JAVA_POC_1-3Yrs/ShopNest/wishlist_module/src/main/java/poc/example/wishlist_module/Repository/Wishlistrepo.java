package poc.example.wishlist_module.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poc.example.wishlist_module.entity.Wishlist;

@Repository
public interface Wishlistrepo extends JpaRepository<Wishlist, Long > {

	//void deleteById(Optional<Wishlist> product);
	//void deleteBypId(long pId);
	
//	Wishlist findByProductId(Long productId);
//    void deleteByProductId(Long productId);
 }

