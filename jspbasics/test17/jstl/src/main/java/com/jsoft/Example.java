package com.jsoft;
import java.util.ListResourceBundle;
public class Example extends ListResourceBundle {
  public Object[][] getContents() {
    return contents;
  }
  static final Object[][] contents = {
  {"count.one", "One"},
  {"count.two", "Two"},
  {"count.three", "Three"},
  };
} 