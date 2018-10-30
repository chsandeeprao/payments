package com.mavsgold.payments.service;

import com.stripe.model.Charge;

public interface ChargesService {

    Charge createCharge(String token);

}
