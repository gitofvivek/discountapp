package com.sincrodigital.controllers;

import com.sincrodigital.models.output.CartResponse;
import com.sincrodigital.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping(value = "purchase{customerType}")
    public ResponseEntity<CartResponse> purchase(@PathVariable(required = true) String customerType, @RequestParam(required = true) double purchaseAmount){
        final CartResponse cartResponse = new CartResponse();
        double billAmount = discountService.purchase(customerType, purchaseAmount);
        cartResponse.setBillAmount(billAmount);
        return new ResponseEntity<CartResponse>(cartResponse,HttpStatus.OK);
    }
}
