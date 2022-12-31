package com.example.smartphones.controller;

import com.example.smartphones.dto.IBookingDto;
import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.model.OderSmartphone;
import com.example.smartphones.service.cart.IOderSmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/cart/count/{id}")
    public ResponseEntity<?> cartCount(@PathVariable("id") Integer id) {
        Optional<IBookingDto> getCarCount = iOderSmartphoneService.getCartCount(id);

        if (getCarCount.isPresent()) {
            return new ResponseEntity<>(getCarCount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/asc/quantity/{id}")
    public ResponseEntity<OderSmartphone> ascQuantity(@PathVariable("id") Integer id) {
        iOderSmartphoneService.ascQuantity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/desc/quantity/{id}")
    public ResponseEntity<OderSmartphone> descQuantity(@PathVariable("id") Integer id) {
        iOderSmartphoneService.descQuantity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/add/cart/{quantity}&{customerId}&{smartphoneId}")
    public ResponseEntity<OderSmartphone> addCart(@PathVariable("quantity") Integer quantity,
                                                 @PathVariable("customerId") Integer customerId,
                                                 @PathVariable("smartphoneId") Integer smartphoneId) {
        iOderSmartphoneService.addSmartphone(quantity, customerId, smartphoneId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/cart/{id}")
    public ResponseEntity<OderSmartphone> deleteCart(@PathVariable("id") Integer id) {
        iOderSmartphoneService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pay/smartphone/{id}")
    public ResponseEntity<OderSmartphone> payBookingLaptop(@PathVariable("id") Integer id) {
        iOderSmartphoneService.payBookingSmartphone(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
