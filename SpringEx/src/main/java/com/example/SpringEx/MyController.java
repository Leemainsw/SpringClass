package com.example.SpringEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("student")
	public String student(Model m) {
		m.addAttribute("title", "Student page");
		m.addAttribute("student", new Student(1, "철수", "chulsoo@naver.com", false));
		
		return "student";
	}
	
	@RequestMapping("/request_param")
	@ResponseBody 
	//return 할 때 템플릿이 아닌 그냥 값을 바로 찍고 싶어서 
	public String requestParamTest(@RequestParam(value="name")String name) {
		return name;
	}
	
	@RequestMapping("/request_param3")
	@ResponseBody 
	// Map<String, String>
	public String requestParamTest3(@RequestParam Map<String, String> params) {
		String result = "";
		for(String key : params.keySet()) {
			result += (key + "/" + params.get(key) + " ");
		}
		return result;
	}
	
	// @PathVariable을 이용하여 URL Path에 포함된 변수 가져오기 가능
	@GetMapping("/path_variable/{abc}/{def}")
	@ResponseBody 
	// 조건 1. 변수 이름과 Mapping에 들어가는 이름이 같아야 함 (abc)
	// 조건 2. @PathVariable 어노테이션에 전달된 값이 같아야 함 (def)
	public String pathVariableTest(@PathVariable Integer abc, @PathVariable("def") String asdf) {
		return abc + "," + asdf;
	}
	
	@GetMapping("/{width}/{height}")
	@ResponseBody
	public String pathVariableTest(
			@PathVariable("width") Integer width,
			@PathVariable Integer height,
			@RequestParam(value="blur", required=false, defaultValue = "0")Integer blur) {
		return width + "," + height + "," + blur;
	}
	
	@GetMapping("student2")
	public ModelAndView student2(Student s) { // 파라미터의 Student 타입을 주목
		ModelAndView m = new ModelAndView("student");
		m.addObject("title", "Student page");
		m.addObject("student", s);
		return m;
	}

	// 리턴 타입이 void임을 주목
	@RequestMapping("/servlet_object")
	public void servletObjectTest(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
	
	// request 객체를 이용하여 요청에 대한 정보 확인 가능
	// 파라미터 정보 접근
	Enumeration<String> e = request.getParameterNames();
	while(e.hasMoreElements()) {
		String name = e.nextElement();
		System.out.println("param : " + name + " : " + request.getParameter(name));
	}
	
	// 헤더 정보 접근
	e = request.getHeaderNames();
	while(e.hasMoreElements()) {
		String name = e.nextElement();
		System.out.println("header : " + name + " : " + request.getHeader(name));
	}
	
	// 바디 정보 접근
	System.out.println("Body\n");
	BufferedReader reader = request.getReader();
	String s = null;
	while((s = reader.readLine()) != null) {
		System.out.println(s);
	}
	
	// response 객체를 이용하여 응답에 대한 정보 추가/변경 가능
	// 응답 코드와 응답 정보에 대한 형식을 헤더 정보에 추가
	response.setStatus(200);
	response.setContentType("application/json");
	response.setCharacterEncoding("utf-8");
	
	// 넘어온 쿼리 스트링 정보를 json 형태로 출력하여 바디에 붙이기
	PrintWriter writer = response.getWriter();
	writer.append("{");
	e = request.getParameterNames();
	String sep = "";
	while(e.hasMoreElements()) {
		String name = e.nextElement();
		writer.append(sep + "\"" + name + "\":");
		writer.append("\"" + request.getParameter(name) + "\"");
		sep = ",";
	}
	writer.append("}");
	}
}
	