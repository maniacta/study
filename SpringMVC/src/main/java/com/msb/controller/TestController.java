package com.msb.controller;

import com.msb.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {//控制器类
    @RequestMapping("/test1")
    public String test1(){
        //响应给浏览器index.jsp页面
        return "index.jsp";
    }
    @RequestMapping("/testParam")
    public String testParam(int sno,String pwd){
        System.out.println(sno+"---"+pwd);
        return "index.jsp";
    }
    @RequestMapping("/testBean")
    public String testBean(Person p){
        System.out.println(p.getName()+"---"+p.getAge()+"---"+p.getScore());
        return "index.jsp";
    }
}
