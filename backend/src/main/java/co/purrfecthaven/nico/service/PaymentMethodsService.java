package co.purrfecthaven.nico.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.PaymentMethods;
import co.purrfecthaven.nico.repository.PaymentMethodsRepository;

/**
 * PaymentMethodsService
 */

@Service
public class PaymentMethodsService {
    
    @Autowired
    private PaymentMethodsRepository paymentMethodsRp;

    public ArrayList<PaymentMethods> getPaymentMethods(){
        return (ArrayList<PaymentMethods>)paymentMethodsRp.findAll();
    }

    public PaymentMethods createPaymentMethod(PaymentMethods paymentMethods){
        return paymentMethodsRp.save(paymentMethods);
    }
}
