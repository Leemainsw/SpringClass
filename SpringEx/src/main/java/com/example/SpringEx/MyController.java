package com.example.SpringEx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller //이걸로 해야 템플릿 적용이 됨
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
	
	@GetMapping("model")
	public String model(Model m) {
		m.addAttribute("title", "Hello World 1234");
		m.addAttribute("content", "Content 1234");
		return "with_model";
	}
	
	@GetMapping("modell_and_view")
	public ModelAndView modelAndView() { // 반환 타입이 modelandview
		ModelAndView m = new ModelAndView("with_model"); // 뷰(템플릿) 이동
		m.addObject("title", "Hello World 1234");
		m.addObject("content", "Content 1234");
		return m;
	}
}
	