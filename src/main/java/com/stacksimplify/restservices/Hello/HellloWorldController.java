package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller


@RestController
public class HellloWorldController {
	
	//simple method
	//URL -/helloworld
	//GET
	//@RequestMapping(method = RequestMethod.GET,path="/helloworld")
	@GetMapping("/helloworld1")
	public String helloworld() {
		return "hello world1";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Kalyan","Reddy","Bangalore");
	}

}
