package com.example.blog_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String showHomePage() {
        return "index"; // 返回Thymeleaf模板文件的名称（不包含后缀）
    }
}
