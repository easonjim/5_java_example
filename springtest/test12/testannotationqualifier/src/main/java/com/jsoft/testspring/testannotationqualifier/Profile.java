package com.jsoft.testspring.testannotationqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	@Autowired
	@Qualifier("student2")
	private Student student;
	
	public void getAge(){
		System.out.println(this.student.getAge());
	}
	
	public void getName() {
		System.out.println(this.student.getName());
	}
}
