package com.example.ShoppingCart.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.example.ShoppingCart.Exception.ProductException;
import com.example.ShoppingCart.Model.*;
import com.example.ShoppingCart.Service.Implimentation.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController
{

	@Autowired
	private ServiceInterface service;

	Logger logger = LoggerFactory.getLogger(MainController.class);

	private String message = null;

	private Map<String, Object> map = null;

	@RequestMapping(path = "/testApparal", method = RequestMethod.GET)
	public void testTwo()
	{
		Apparal apparal = new Apparal();
		apparal.setBrand("Appreal1");
		apparal.setDesign("XL");
		apparal.setPrice(1499);
		apparal.setProductName("Black");
		apparal.setType("Shirt");
		logger.info("Initializing the apparal table with: " + apparal);
		service.saveApparal(apparal);
	}

	@RequestMapping(path = "/testBook", method = RequestMethod.GET)
	public void test()
	{

		Book book = new Book();
		book.setAuthor("TestBook1");
		book.setGener("Comedy");
		book.setPrice(999);
		book.setProductName("Test of the Book");
		book.setPublications("Publications");
		logger.info("Initializing the book table with: " + book);
		service.saveBook(book);

		Cart cart = new Cart();
		User user = new User();
		user.setUserName("ABC");
		user.setCart(cart);
		logger.info("Initializing the user table with: " + user);
		service.saveUser(user);
	}


	@RequestMapping(path = "/search/{key}", method = RequestMethod.GET)
	public Map<String, Object> search(@PathVariable String key)
	{
		this.map = new HashMap<>();
		Set<Product> products = null;
		logger.info("Searching the database for: " + key);
		try {
			products = service.search(key);
			if (products.size() == 0) {
				map.put("Success", true);
				map.put("Object", products);
				map.put("Message", "No Products Available");
				logger.info("No products found for provided search query");
			} else {
				map.put("Success", true);
				map.put("Object", products);
				logger.info("Available products" + products);
			}

		} catch (Exception e) {
			map.put("Success", false);
			map.put("Object", null);
			map.put("Message", e.getMessage());
			logger.debug("Some exception has occured with message: " + e.getMessage());
		}
		return map;
	}

	@RequestMapping(path = "/addProduct/{userId}/{productId}/{count}", method = RequestMethod.POST)
	public Map<String, Object> addProduct(@PathVariable int userId, @PathVariable int productId,
			@PathVariable int count) {
		this.map = new HashMap<>();

		try {
			message = this.service.addProduct(userId, productId, count);
			map.put("Success", true);
			map.put("Object", message);
			map.put("Message", message);
			logger.info("Successfully added the product");
		} catch (ProductException e) {
			map.put("Success", false);
			map.put("Object", "Negative product count");
			map.put("Message", e.getMessage());
			logger.debug("Product exception has occured with message: " + e.getMessage());
		} catch (NoSuchElementException e) {
			map.put("Success", false);
			map.put("Object", "Invalid ID");
			map.put("Message", e.getMessage());
			logger.debug("NoSuchElementException exception has occured with message: " + e.getMessage());
		} catch (Exception e) {
			map.put("Success", false);
			map.put("Object", "Some Error Occured");
			map.put("Message", e.getMessage());
			logger.debug("Some exception has occured with message: " + e.getMessage());
		}
		return map;
	}

	@RequestMapping(path = "/removeProduct/{productId}", method = RequestMethod.PUT)
	public Map<String, Object> removeProduct(@PathVariable int productId) {
		this.map = new HashMap<>();
		try
		{
			message = service.removeFromCart(productId);
			map.put("Success", true);
			map.put("Object", message);
			map.put("Message", message);
			logger.info("Successfully removed the product");
		} catch (NoSuchElementException e) {
			map.put("Success", false);
			map.put("Object", "Invalid ID");
			map.put("Message", e.getMessage());
			logger.debug("NoSuchElementException exception has occured with message: " + e.getMessage());
		} catch (Exception e) {
			map.put("Success", false);
			map.put("Object", "Some Error Occured");
			map.put("Message", e.getMessage());
			logger.debug("Some exception has occured with message: " + e.getMessage());
		}
		return map;
	}

	@RequestMapping(path = "/removeAllProducts", method = RequestMethod.PUT)
	public Map<String, Object> removeAllProduct() {
		this.map = new HashMap<>();
		try {
			message = service.removeAllProducts();
			map.put("Success", true);
			map.put("Object", message);
			map.put("Message", message);
			logger.info("Successfully removed all products");
		} catch (NoSuchElementException e) {
			map.put("Success", false);
			map.put("Object", "Invalid ID");
			map.put("Message", e.getMessage());
			logger.debug("NoSuchElementException exception has occured with message: " + e.getMessage());
		} catch (Exception e) {
			map.put("Success", false);
			map.put("Object", "Some Error Occured");
			map.put("Message", e.getMessage());
			logger.debug("Some exception has occured with message: " + e.getMessage());
		}
		return map;
	}

	@RequestMapping(path = "/viewCart/{userId}", method = RequestMethod.GET)
	public Map<String, Object> viewCart(@PathVariable int userId) {
		this.map = new HashMap<>();

		try {
			Cart cart = service.viewCart(userId);
			float price = service.calculatePrice(cart);
			message = "Success";
			map.put("Success", true);
			map.put("Bill to be paid", price);
			map.put("Object", cart);
			map.put("Message", message);
			logger.info("Showing cart: " + cart + " Price: " + price);
		} catch (NoSuchElementException e) {
			map.put("Success", false);
			map.put("Object", "Invalid ID");
			map.put("Message", e.getMessage());
			logger.debug("NoSuchElementException exception has occured with message: " + e.getMessage());
		} catch (Exception e) {
			map.put("Success", false);
			map.put("Object", "Some Error Occured");
			map.put("Message", e.getMessage());
			logger.debug("Some exception has occured with message: " + e.getMessage());
		}
		return map;
	}

}
