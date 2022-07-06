package com.example.ShoppingCart.Service.Implimentation;

import java.util.Set;

import com.example.ShoppingCart.Exception.ProductException;
import com.example.ShoppingCart.Model.*;

public interface ServiceInterface {

	void saveUser(User user);

	void saveApparal(Apparal apparal);

	void saveBook(Book book);

	Set<Product> search(String key) throws Exception;

	String addProduct(int userId, int productId, int count) throws ProductException;

	String removeFromCart(int productId);

	Cart viewCart(int userId);
	
	float calculatePrice(Cart cart);

	String removeAllProducts();
}
