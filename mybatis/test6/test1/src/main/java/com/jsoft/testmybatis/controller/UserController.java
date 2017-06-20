package com.jsoft.testmybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.testmybatis.inter.IUserOperation;
import com.jsoft.testmybatis.models.Article;

@Controller
@RequestMapping("/article")
public class UserController {
    @Autowired
    IUserOperation userMapper;

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
        List<Article> articles=userMapper.getUserArticles(1); 
        ModelAndView mav=new ModelAndView("/article/list");
        mav.addObject("articles",articles);
        return mav;
    }
}
