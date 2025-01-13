package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HellowController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
        return "Hello Spring Boot Board"; 
	}
	
}
