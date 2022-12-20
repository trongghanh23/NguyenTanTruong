package com.example.smartphones.controller;

import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.service.cart.IOderSmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/booking")
public class OderSmartphoneRest {
    @Autowired
    private IOderSmartphoneService iOderSmartphoneService;
    @GetMapping("/list/cart/{id}")
    public ResponseEntity<List<SmartphoneDto>> showCartByUser(@PathVariable("id") Integer id) {
        List<SmartphoneDto> cart = iOderSmartphoneService.findCartByUser(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

//    @GetMapping("/cart-count/{id}")
//    public ResponseEntity<?> cartCount(@PathVariable("id") Integer id) {
//        Optional<IBookingLaptopDto> getCarCount = bookingLaptopService.getCartCount(id);
//
//        if (getCarCount.isPresent()) {
//            return new ResponseEntity<>(getCarCount, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
