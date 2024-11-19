package co.purrfecthaven.nico.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.ShippingDetailsDTO;
import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.model.ShippingDetails;
import co.purrfecthaven.nico.repository.OrdersRepository;
import co.purrfecthaven.nico.repository.ShippingDetailsRepository;

/**
 * ShippingDetailsService
 */

@Service
public class ShippingDetailsService {

    @Autowired
    private ShippingDetailsRepository shippingDetailsRp;
    @Autowired
    private OrdersRepository ordersRp;
 
    public ArrayList<ShippingDetails> getShippingDetails(){
        return (ArrayList<ShippingDetails>)shippingDetailsRp.findAll();
    }

    public Optional<ShippingDetails> getShippingDetailsById(Integer id){
        return shippingDetailsRp.findById(id);
    }

    public ShippingDetails createShippingDetails(ShippingDetailsDTO shippingDetailsDTO){
        ShippingDetails shippingDetails = new ShippingDetails();
        Orders orders = ordersRp.findById(shippingDetailsDTO.getOrderId()).orElseThrow(() -> new IllegalArgumentException("Orden no encontrada" + shippingDetailsDTO.getOrderId()));
        
        shippingDetails.setOrders(orders);
        shippingDetails.setCreatedAt(LocalDateTime.now());
        shippingDetails.setStatus("Activo");
        shippingDetails.setDeliveryDate(shippingDetailsDTO.getDeliveryDate());
        shippingDetails.setShippingdate(shippingDetailsDTO.getShippingDate());
        shippingDetails.setShippingAddress(shippingDetailsDTO.getShippingAddress());
        shippingDetails.setProviderName(shippingDetailsDTO.getProviderName());

        shippingDetailsRp.save(shippingDetails);
        return shippingDetails;

    }

    public ShippingDetails updateShippingDetailsById(ShippingDetailsDTO request,Integer id){
        ShippingDetails shippingDetails = shippingDetailsRp.findById(id).get();

        shippingDetails.setStatus(request.getStatus());
        shippingDetails.setShippingAddress(request.getShippingAddress());
        shippingDetails.setDeliveryDate(request.getDeliveryDate());
        shippingDetails.setProviderName(request.getProviderName());

        shippingDetailsRp.save(shippingDetails);
        return shippingDetails;
    }

}
