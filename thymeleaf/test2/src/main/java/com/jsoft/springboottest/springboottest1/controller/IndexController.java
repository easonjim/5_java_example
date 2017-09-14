package com.jsoft.springboottest.springboottest1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        Entry entry = new Entry();
        entry.setText("Text");
        entry.setTitle("Title");
        model.addAttribute("entries", entry);
        model.addAttribute("entry", new Entry());
        return "index";
    }

}
