package com.jsoft.testspring.testmvchelloworld;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String printHello(ModelMap model, HttpSession session){
	    // Redis
	    System.out.println(stringRedisTemplate.opsForValue().get("test"));
	    // Session
	    UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        System.out.println(session.getId());
		model.addAttribute("message","Hello Spring MVC Framework!");
		return "hello";
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String set() {
	    stringRedisTemplate.opsForValue().set("test", new Date().toString());
	    return "hello";
	}
}
