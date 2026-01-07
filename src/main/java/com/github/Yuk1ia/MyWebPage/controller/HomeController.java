package com.github.Yuk1ia.MyWebPage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 处理根路径 http://localhost:8080
    public String home() {
        return "index"; // 告诉Spring Boot使用 `index.html` 模板
    }
}