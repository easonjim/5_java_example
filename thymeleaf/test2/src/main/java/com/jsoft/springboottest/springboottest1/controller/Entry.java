package com.jsoft.springboottest.springboottest1.controller;

public class Entry {
	public String title;
	public String text;

	public Entry() {

	}

	public Entry(String title, String text) {
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
