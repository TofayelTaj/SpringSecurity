package com.example.Spring.Security.Security;

import com.example.Spring.Security.Repositories.UserRepository;
import com.example.Spring.Security.UsersEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user =  userRepository.loadUserByUserName(username);

         if(user == null){
             throw new UsernameNotFoundException("User Not Found !!");
         }

         UserDetails userDetails = new ApplicationUserDetais(user);
         return userDetails;

    }
}
