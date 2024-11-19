package co.purrfecthaven.nico.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.OrderDetails;
import co.purrfecthaven.nico.repository.OrderDetailsRepository;

/**
 * OrderDetailsService
 */

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRp;

    public ArrayList<OrderDetails> getAll(){
        return (ArrayList<OrderDetails>) orderDetailsRp.findAll();
    }

    public OrderDetails createOrderDetails(OrderDetails orderDetails){
        return orderDetailsRp.save(orderDetails);
    }
   
}
