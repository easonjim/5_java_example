package com.jsoft.testspring.testannotationautowired;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	private SpellChecker spellChecker;
	private String name;
	
	@Autowired
	public void setSpellChecker(SpellChecker spellChecker){
		System.out.println("TextEditor通过setter初始化");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void getName(){
		System.out.println(this.name);
	}
	
}
