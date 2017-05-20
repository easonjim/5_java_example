package com.jsoft.testspring.testconstructor;

public class TextEditor {
	private SpellChecker spellChecker;
	
	public TextEditor(SpellChecker spellChecker){
		System.out.println("TextEditor有参数构造函数初始化");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}
	
}
