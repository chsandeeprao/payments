package com.mavsgold.payments.controller;

import com.mavsgold.payments.service.ChargesService;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/charges")
public class ChargesController {

    @Autowired
    private ChargesService chargesService;

    public ChargesController(ChargesService chargesService) {
        this.chargesService = chargesService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCharge(@RequestBody String token) {

        Charge charge = chargesService.createCharge(token);

        return charge.getStatus();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String retrieveCharges(@RequestParam("id") Integer id) {

        List<Charge> charge = new ArrayList<>();

        //chargesService.createCharge(amount);

        return "";
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCharge(@RequestBody String token) {

        Charge charge = chargesService.createCharge(token);

        return charge.getStatus();
    }

    

}
