package com.example.SpringEx;

import java.io.Serializable;

//(3) Serializable 인터페이스를 구현
public class Student implements Serializable {
	// (1) 모든 필드의 접근 제어자는 private (게터, 세터를 제공)
	private Integer id;
	private String name;
	private String email;
	private boolean genius;
	
	// (2) 외부에서 접근 가능한(public) 기본 생성자(no-arg constructor) 제공
	public Student() {
		super();
	}
	
	public Student(Integer id, String name, String email, boolean genius) {
		super();
		this.id = id;
		
		//게터, 세터 메소드에 대한 제약 사항
		this.name = name;
		this.email = email;	
		this.genius = genius;
	}
	
	// 필드에 대한 게터, 세터 제공
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// 게터의 이름 주목 (isGenius)
	public boolean isGenius() {
		return genius;
	}
	
	public void setGenius(boolean genius) {
		this.genius = genius;
	}
}