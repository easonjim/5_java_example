package com.jsoft.testspring.testinnerbean;

public class TextEditor {
	private SpellChecker spellChecker;
	
	public void setSpellChecker(SpellChecker spellChecker){
		System.out.println("TextEditor通过setter初始化");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}
	
}
