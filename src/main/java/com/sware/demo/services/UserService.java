package com.sware.demo.services;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sware.demo.domains.User;
import com.sware.demo.repositories.UserRepository;
@Service
public class UserService {
	@Autowired
	 UserRepository userRepository;

	public String createUser(User user) {
		User resultantUser=null;
		ArrayList<User> usrList=new ArrayList<User>();
		try {
			
			usrList=userRepository.findByEmail(user.getEmail());
			if(usrList.size()!=0){
				return "Error:User with this email already exist.";
			}
			resultantUser=userRepository.save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultantUser.getId()+" :created successfully...!!!!";
	}

	public String updateUser(User user) {
		User resultantUser=null;
		try {
			resultantUser=userRepository.findById(user.getId());
			if(resultantUser!=null){
				
				
				if((resultantUser.getfName().equals(user.getfName())) && (resultantUser.getlName().equals(user.getlName())) && (resultantUser.getEmail().equals(user.getEmail())) ){
					userRepository.save(user);
				}
				else{
					
					return "Error: Only pin code and dob can be updated.";
				}
			}
			else{
				return "User not found to update.";
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user.getId()+" :updated successfully...!!!!";
	}

	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			userRepository.save(user);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "user deleted";
	}
}
