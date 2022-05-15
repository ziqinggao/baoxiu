package com.spb.houqin.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("admin")
@Controller
public class IndexController  {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "admin/welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

}
