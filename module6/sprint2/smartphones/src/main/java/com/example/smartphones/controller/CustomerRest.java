package com.example.smartphones.controller;

import com.example.smartphones.dto.ICustomerDto;
import com.example.smartphones.jwt.JwtTokenUtil;
import com.example.smartphones.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRest {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

}
