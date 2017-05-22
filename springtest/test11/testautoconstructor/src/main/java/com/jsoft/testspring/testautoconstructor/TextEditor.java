package com.jsoft.testspring.testautoconstructor;

public class TextEditor {
	private SpellChecker spellChecker;
	private String name;
	
	public TextEditor(SpellChecker spellChecker, String name) {
		System.out.println("SpellChecker通过构造函数初始化");
		this.spellChecker = spellChecker;
		this.name = name;
	}
	
	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}

	public void getName(){
		System.out.println(this.name);
	}
	
}
