package com.example.SpringEx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController2 {
	@GetMapping("/hello2")
	public String hello2() {
		return "hello";//hello.html 뷰 (템플릿)을 사용
	}
}
