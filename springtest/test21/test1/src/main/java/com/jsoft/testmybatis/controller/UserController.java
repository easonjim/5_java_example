package com.jsoft.testmybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.testmybatis.inter.IUserOperation;
import com.jsoft.testmybatis.models.Article;

@Controller
@RequestMapping("/article")
public class UserController {
    
	@Value("#{config['jdbc.username']}")
	private String userName;
	
	@Value("#{config['jdbc.password']}")
	private String password;
	
	@Value("#{config['jdbc.url']}")
	private String url;
	
	@Value("#{config['jdbc.driver']}")
	private String driver;
	
	@Autowired
    IUserOperation userMapper;

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
    	
    	System.out.println("测试："+this.userName+"-"+this.password+"-"+this.url+"-"+this.driver);
    	
        List<Article> articles=userMapper.getUserArticles(1); 
        ModelAndView mav=new ModelAndView("/article/list");
        mav.addObject("articles",articles);
        return mav;
    }
}
