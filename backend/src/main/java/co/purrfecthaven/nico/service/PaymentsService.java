package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.PaymentsDTO;
import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.model.Payments;
import co.purrfecthaven.nico.repository.OrdersRepository;
import co.purrfecthaven.nico.repository.PaymentsRepository;

/**
 * PaymentsService
 */
@Service
public class PaymentsService {
    
    @Autowired
    private PaymentsRepository paymentsRp;

    @Autowired
    private OrdersRepository ordersRp;



    public ArrayList<Payments> getPayments(){
        return (ArrayList<Payments>)paymentsRp.findAll();
    }

    public Payments createPayment(PaymentsDTO paymentsDTO){
        Payments payments = new Payments();
        Orders orders = ordersRp.findById(paymentsDTO.getOrderId()).orElseThrow(() -> new IllegalArgumentException("Orden no encontrada" + paymentsDTO.getOrderId()));

        payments.setAmount(paymentsDTO.getAmount());
        payments.setCreatedAt(LocalDateTime.now());
        payments.setOrders(orders);
        payments.setPaymentDate(LocalDateTime.now());
        payments.setPaymentMethods(paymentsDTO.getPaymentMethods());

        paymentsRp.save(payments);
        return payments;
    }
    
}
