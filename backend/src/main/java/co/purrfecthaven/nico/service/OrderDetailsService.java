package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.OrderDetailsDTO;
import co.purrfecthaven.nico.model.OrderDetails;
import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.repository.OrderDetailsRepository;
import co.purrfecthaven.nico.repository.OrdersRepository;

/**
 * OrderDetailsService
 */

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRp;

    @Autowired
    private OrdersRepository ordersRp;

    public ArrayList<OrderDetails> getAll(){
        return (ArrayList<OrderDetails>) orderDetailsRp.findAll();
    }

    public OrderDetails createOrderDetails(OrderDetailsDTO orderDetailsDTO){
        OrderDetails orderDetails = new OrderDetails();
        Orders orders = ordersRp.findById(orderDetailsDTO.getOrderId()).orElseThrow(()-> new IllegalArgumentException("Orden no encontrada" + orderDetailsDTO.getOrderId()));

        orderDetails.setOrders(orders);
        orderDetails.setCreatedAt(LocalDateTime.now());
        orderDetails.setPrice(orderDetailsDTO.getPrice());
        orderDetails.setQuantity(orderDetailsDTO.getQuantity());

        orderDetailsRp.save(orderDetails);
        return orderDetails;
    }

    public Optional<OrderDetails> getOrderDetailsById(Integer id){
        return orderDetailsRp.findById(id);
    }
   
}
