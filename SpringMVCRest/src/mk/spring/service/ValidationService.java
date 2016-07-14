package mk.spring.service;

import mk.spring.entity.User;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	
	public User validateUser(String username,String password){
		if(username.equals("mayank") && password.equals("pass")){
			return new User(101,"mayank","pass");
		}
		return null;
	}
}
