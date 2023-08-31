package com.spring.jwtapp.controller;

import com.spring.jwtapp.model.JwtRequest;
import com.spring.jwtapp.service.CustomUserDetailsService;
import com.spring.jwtapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/generateToken")
    public ResponseEntity<String> generateToken(@RequestBody JwtRequest jwtRequest){

        try{
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));

        }catch(UsernameNotFoundException e){
            e.printStackTrace();
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(token, HttpStatus.OK);

    }

}
