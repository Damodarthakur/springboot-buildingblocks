package com.stacksimplify.restservices.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {

	//Autowire the UserRepository
	@Autowired
	private UserRepository userRepository;
	
	//getAllUsers Method
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	// Create user method 
	public User createUser(User user) throws UserExistsException {
		
		//If user exists using username
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		
		//If not exists throw UserExistsException
		if(existingUser != null) {
			throw new UserExistsException("user already exists in repository");
		}
		
		return userRepository.save(user);
	}
	
	//GetUserById
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found in user repository");
		}
		return user;
	}
	
	//UpdateUserById
	public User updateUserById(Long id,User user) throws UserNotFoundException {
Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in user repository,provide the correct userId");
		}
		user.setUserid(id);
		return userRepository.save(user);
	}
	
	//deleteUserById
		public void deleteUserById(Long id) {
			Optional<User> user = userRepository.findById(id);
			
			if(!user.isPresent()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in user repository");
			}
				userRepository.deleteById(id);
		
		}
		
	//getUserByUsername
		public User getUserByUsername(String username) {
			
			return userRepository.findByUsername(username);
		}
		
		
	
}
