package com.example.SpringEx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("/hello")
	public String hello(){
		return "<h1>Hello</h1>";
	}
}
