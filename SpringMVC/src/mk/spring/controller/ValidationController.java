package mk.spring.controller;

import mk.spring.entity.User;
import mk.spring.service.ValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/validate")
public class ValidationController {
	
	@Autowired 
	ValidationService valService;
	
	@RequestMapping(path="/user",method=RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam String username,@RequestParam String password){
		User validatedUser = valService.validateUser(username,password);
		
		ModelAndView mv = new ModelAndView();
		if(validatedUser != null){
			mv.setViewName("home");
			mv.addObject("user", validatedUser);
		}
		else{
			mv.setViewName("index");
			mv.addObject("msg","Invalid Username or password");
		}
		return mv;
	}
}
