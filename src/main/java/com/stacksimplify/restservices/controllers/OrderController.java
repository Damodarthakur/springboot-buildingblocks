package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;

import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	// get all orders for a user
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userid);
		  
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		return userOptional.get().getOrders();
		
	}
	
	//Create Order method
	
	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(userid);
		  
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not found");
		 
		User user = userOptional.get();
		
		order.setUser(user);
		
		return orderRepository.save(order);
		
	}
	
	
	//getOrderByOrderId
	
	@GetMapping("/{userid}/orders/{orderId}")
	public Optional<Order> getOrderByOrderId(@PathVariable Long orderId) throws UserNotFoundException{
		
		
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		  
		if(!orderOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		return orderOptional;
	}	
		
		
	
	
	
	
	
	
	
	

}
