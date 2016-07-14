package mk.spring.test;

import mk.spring.service.ValidationService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");

		ValidationService service = (ValidationService) context.getBean(ValidationService.class);
		
		System.out.println(service.validateUser("mayank", "pass"));
		System.out.println(service.validateUser("admin", "admin"));
	} 
}
