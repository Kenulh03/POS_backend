package com.ijse.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.dto.LoginDto;
import com.ijse.hellospring.dto.TokenDto;
import com.ijse.hellospring.security.jwt.JwtUtils;
import com.ijse.hellospring.service.UserServiceImpl;;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {

        TokenDto tokenDto = new TokenDto();
        
        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.
        getPassword()));

        final UserDetails userdetail = userServiceImpl.findUserByUsername(loginDto.getUsername());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtUtils.generateJwtToken(authentication);

        if (userdetail != null){
            tokenDto.setToken(jwtToken);
            tokenDto.setRole(userServiceImpl.getRoleByUsername(loginDto.getUsername()));
            return ResponseEntity.ok(tokenDto);
        }
        return ResponseEntity.status(400).body("some error");
    }
}
