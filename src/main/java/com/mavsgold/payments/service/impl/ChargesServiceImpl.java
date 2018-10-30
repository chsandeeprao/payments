package com.mavsgold.payments.service.impl;

import com.mavsgold.payments.service.ChargesService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChargesServiceImpl implements ChargesService {
    @Override
    public Charge createCharge(String amount) {

        Charge charge = null;

        // Set your secret key: remember to change this to your live secret key in production
        // See your keys here: https://dashboard.stripe.com/account/apikeys
        Stripe.apiKey = "sk_test_SXdslF";


        String token = "tok_1DPzKaEcAcnWKXu1RezEgxtg";

        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", "usd");
        params.put("source", token);
        params.put("receipt_email", "jenny.rosen@example.com");
        try {
            charge = Charge.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return charge;

    }
}
