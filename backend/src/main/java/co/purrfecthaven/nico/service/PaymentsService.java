package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.PaymentsDTO;
import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.model.PaymentMethods;
import co.purrfecthaven.nico.model.Payments;
import co.purrfecthaven.nico.repository.OrdersRepository;
import co.purrfecthaven.nico.repository.PaymentMethodsRepository;
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

    @Autowired
    private PaymentMethodsRepository paymentMethodsRp;

    public Optional<Payments> getPaymentById(Integer id ){
        return paymentsRp.findById(id);
    }

    public Payments createPayment(PaymentsDTO paymentsDTO){
        Payments payments = new Payments();
        PaymentMethods paymentMethods = paymentMethodsRp.findById(paymentsDTO.getPaymentMethod()).orElseThrow(() -> new IllegalArgumentException("Metodo de pago no encontrado" + paymentsDTO.getPaymentMethod()));
        Orders orders = ordersRp.findById(paymentsDTO.getOrderId()).orElseThrow(() -> new IllegalArgumentException("Orden no encontrada" + paymentsDTO.getOrderId()));

        payments.setAmount(paymentsDTO.getAmount());
        payments.setPaymentMethods(paymentMethods);
        payments.setCreatedAt(LocalDateTime.now());
        payments.setOrders(orders);
        payments.setPaymentDate(LocalDateTime.now());

        paymentsRp.save(payments);
        return payments;
    }
    
}
