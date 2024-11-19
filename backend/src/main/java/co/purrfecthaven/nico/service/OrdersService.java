package co.purrfecthaven.nico.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.repository.OrdersRepository;

/**
 * OrdersService
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRp;

    public ArrayList<Orders> getOrders(){
        return (ArrayList<Orders>) ordersRp.findAll();
    }

    public Orders createOrders(Orders orders){
        return ordersRp.save(orders);
    }

    public Orders updateOrder (Orders request, Integer id){
        Orders orders = ordersRp.findById(id).get();
        
        orders.setStatus(request.getStatus());
        
        ordersRp.save(orders);
        return orders;
    }


}
