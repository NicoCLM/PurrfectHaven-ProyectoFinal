package co.purrfecthaven.nico.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.ShippingDetails;
import co.purrfecthaven.nico.repository.ShippingDetailsRepository;

/**
 * ShippingDetailsService
 */

@Service
public class ShippingDetailsService {

    @Autowired
    private ShippingDetailsRepository shippingDetailsRp;

    public ArrayList<ShippingDetails> getShippingDetails(){
        return (ArrayList<ShippingDetails>)shippingDetailsRp.findAll();
    }

    public Optional<ShippingDetails> getShippingDetailsById(Integer id){
        return shippingDetailsRp.findById(id);
    }

    public ShippingDetails createShippingDetails(ShippingDetails shippingDetails){
        return shippingDetailsRp.save(shippingDetails);
    }

}
