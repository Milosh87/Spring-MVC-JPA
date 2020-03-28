package rs.engineering.javacourse.myspringmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = "/home")
	public String home() {
		System.out.println("============== HomeController: home() ===========================");
		
		return "home";
	}
}