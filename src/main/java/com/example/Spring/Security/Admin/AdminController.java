package com.example.Spring.Security.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/api/student")
public class AdminController {

    @GetMapping("/")
    @ResponseBody
    public String getResponse(){
        return "this url only for admins";
    }

}
