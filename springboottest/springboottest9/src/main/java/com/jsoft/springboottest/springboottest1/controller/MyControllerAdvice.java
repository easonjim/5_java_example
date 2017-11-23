package com.jsoft.springboottest.springboottest1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller增强器
 *
 * @author jim
 * @date 2017/11/23
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ModelAttribute
    public void changeModel(Model model) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        model.addAttribute("author", "Jim");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }


    /**
     * 设置要捕获的异常，并作出处理
     * 注意：这里可以返回试图，也可以放回JSON，这里就当做一个Controller使用
     *
     * @param request {@link NativeWebRequest}
     * @param e {@link Exception}
     * @return {@link Map}
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map processUnauthenticatedException(NativeWebRequest request, Exception e) {
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出Exception异常时执行");
        Map map = new HashMap(5);
        map.put("code", 404);
        map.put("msg", e.getMessage());
        return map;
    }
}
