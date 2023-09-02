package com.spring.jwtmongo.controller;

import com.spring.jwtmongo.request.JwtRequest;
import com.spring.jwtmongo.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/getToken")
    public ResponseEntity<String> getToken(@RequestBody JwtRequest jwtRequest){

        try{
            Authentication authentication =
                    authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
            return new ResponseEntity<>(jwtUtils.generateToken(jwtRequest.getUsername()),HttpStatus.OK);
        }
        catch (Exception e){
            throw new UsernameNotFoundException("Username invalid");
        }


    }

}
