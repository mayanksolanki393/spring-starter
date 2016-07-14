package mk.spring.rest.controller;

import mk.spring.entity.User;
import mk.spring.service.ValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/validate")
public class ValidationController {
	
	@Autowired
	ValidationService valService;
	
	@RequestMapping(path="/user",method=RequestMethod.POST)
	public ResponseEntity validateUser(@RequestParam String username,@RequestParam String password){
		
		User validatedUser = valService.validateUser(username,password);
		
		if(validatedUser != null){
			return ResponseEntity.ok().body(validatedUser);
		}
		else{
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}
