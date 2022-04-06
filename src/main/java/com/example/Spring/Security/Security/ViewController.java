package com.example.Spring.Security.Security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String getDashboardView(){
        return  "dashboard";
    }





}
