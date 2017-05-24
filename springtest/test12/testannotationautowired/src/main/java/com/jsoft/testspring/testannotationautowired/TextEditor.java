package com.jsoft.testspring.testannotationautowired;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private SpellChecker spellChecker;
    private String name;
    
    @Autowired
    public TextEditor(SpellChecker spellChecker){
        System.out.println("TextEditor通过初始化方法赋值SpellChecker");
        this.spellChecker = spellChecker;
    }
        
    public void spellCheck() {
        this.spellChecker.checkSpelling();
    }
    
    @Autowired(required=false)
    public void setName(String name){
        this.name = name;
    }
    
    public void getName(){
        System.out.println(this.name);
    }
    
}