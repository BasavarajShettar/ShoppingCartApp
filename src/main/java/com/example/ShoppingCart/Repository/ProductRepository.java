package com.example.ShoppingCart.Repository;

import javax.transaction.Transactional;

import com.example.ShoppingCart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
