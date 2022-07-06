package com.example.ShoppingCart.Repository;

import com.example.ShoppingCart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
}
