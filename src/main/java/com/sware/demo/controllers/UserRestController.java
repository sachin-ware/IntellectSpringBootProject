package com.sware.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sware.demo.domains.User;
import com.sware.demo.repositories.UserRepository;
import com.sware.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	
	
	@Autowired
	UserService userService;
	
	
	
	
	@PostMapping("/create")
	public  ResponseEntity<String> createUser(@RequestBody User user){
		
		String id=null;
		HttpStatus status=null;
		try {
			if(user!=null){
				user.setActive(true);
			}
			id=userService.createUser(user);
			status=(id=="Error:User with this email already exist.")?HttpStatus.ALREADY_REPORTED:HttpStatus.OK;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return  new ResponseEntity<>(id,status);
		
	}
	
	@PutMapping("/update")
	public  ResponseEntity<String> updateUser(@RequestBody User user){

		String id=null;
		try {
			if(user!=null){
				user.setActive(true);
			}
			id=userService.updateUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return  new ResponseEntity<>(id,HttpStatus.OK);

	}
	
	@DeleteMapping("/delete")
	public  ResponseEntity<String> deleteUser(@RequestBody User user){

		String msg=null;
		try {
			if(user!=null){
				user.setActive(false);
			}
			msg=userService.deleteUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return  new ResponseEntity<>(msg,HttpStatus.OK);

	}
	
}
