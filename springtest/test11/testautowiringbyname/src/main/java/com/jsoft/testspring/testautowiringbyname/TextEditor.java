package com.jsoft.testspring.testautowiringbyname;

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
