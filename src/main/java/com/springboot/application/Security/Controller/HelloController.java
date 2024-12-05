package com.springboot.application.Security.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/demo")
public class HelloController {

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello controller Admin";
    }

    @GetMapping("/protected")
    public String getProtected() {
        return "Hello controller protected";
    }
    
    
    @GetMapping("/public")
    public String getMethodName() {
        return "Hello controller public";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Hello controller user";
    }
}
