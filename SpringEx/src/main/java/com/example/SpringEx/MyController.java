package com.example.SpringEx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping("Bye")
	@ResponseBody
	public String bye() {
		return "<h1>Bye</h1>";
	}
	
	@RequestMapping(value="Bye2", method=RequestMethod.GET)
	@ResponseBody
	public String bye2() {
		return "<h1>Bye2</h1>";
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	@ResponseBody
	public String post() {
		return "<h1>post</h1>";
	}
	
	@RequestMapping("/word")	
	public String word() {
		return "word";
	}


}
	