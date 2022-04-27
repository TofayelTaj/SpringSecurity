package com.example.Spring.Security.Controllers;

import com.example.Spring.Security.Repositories.UserRepository;
import com.example.Spring.Security.UsersEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user){
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
        return "login";
    }


}
