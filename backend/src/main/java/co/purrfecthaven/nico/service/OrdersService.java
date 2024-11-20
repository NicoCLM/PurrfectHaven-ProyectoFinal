package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.OrdersDTO;
import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.repository.OrdersRepository;
import co.purrfecthaven.nico.repository.UserRepository;

/**
 * OrdersService
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRp;

    @Autowired
    private UserRepository userRp;

    public ArrayList<Orders> getOrders(){
        return (ArrayList<Orders>) ordersRp.findAll();
    }

    public Orders createOrders(OrdersDTO ordersDTO){
        Orders orders = new Orders();
        User user = userRp.findById(ordersDTO.getUserId()).orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado" + ordersDTO.getUserId()));
        
        orders.setCreatedAt(LocalDateTime.now());
        orders.setAddress(ordersDTO.getAddress());
        orders.setOrderDate(LocalDateTime.now().plusDays(4));
        orders.setUser(user);
        orders.setStatus("ACTIVO");

        ordersRp.save(orders);;
        return orders;
    }

    public Orders updateOrder (OrdersDTO request, Integer id){
        Orders orders = ordersRp.findById(id).get();
        
        orders.setStatus(request.getStatus());
        
        ordersRp.save(orders);
        return orders;
    }


}
