package com.example.smartphones.controller;

import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.jwt.JwtTokenUtil;
import com.example.smartphones.model.customer.Customer;
import com.example.smartphones.service.customer.ICustomerService;
import com.example.smartphones.service.smartphone.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphone")
public class SmartphoneRest {
    @Autowired
    private ISmartphoneService iSmartphoneService;
        @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @GetMapping("/list/home")
    public ResponseEntity<Page<SmartphoneDto>> getAllSmartphone(@RequestParam(value = "name", defaultValue = "") String name,
                                                           @PageableDefault Pageable pageable) {
        Page<SmartphoneDto> smartphonePage = iSmartphoneService.findAllHome(name, pageable);
        if (smartphonePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<SmartphoneDto>>getDetail(@PathVariable Integer id){
        Optional<SmartphoneDto>smartphoneDto=iSmartphoneService.detailSmartphone(id);
        if (!smartphoneDto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphoneDto,HttpStatus.OK);

    }

    @GetMapping("/get/customer")
    public ResponseEntity<Customer> getCustomerByUsername(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        String username = jwtTokenUtil.getUsernameFromJwtToken(headerAuth.substring(7));
        System.out.println(username);
        Customer customer = iCustomerService.findCustomerByUsername(username);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
