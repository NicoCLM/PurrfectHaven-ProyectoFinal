package co.purrfecthaven.nico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.Payments;
import co.purrfecthaven.nico.repository.PaymentsRepository;

/**
 * PaymentsService
 */
@Service
public class PaymentsService {
    
    @Autowired
    private PaymentsRepository paymentsRp;

    public Optional<Payments> getPaymentById(Integer id ){
        return paymentsRp.findById(id);
    }

    public Payments createPayment(Payments payments){
        return paymentsRp.save(payments);
    }
    
}
