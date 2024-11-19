package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.Product;
import co.purrfecthaven.nico.repository.ProductRepository;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRp;

    public ArrayList<Product> getAll(){
        return (ArrayList<Product>) productRp.findAll();
    }

    public Product createProduct (Product product){
        return productRp.save(product);
    }

    public Product updateProduct (Product request, Integer id){
        Product product = productRp.findById(id).get();

        product.setName(request.getName());
        product.setDescription(request.getDescription());

        productRp.save(product);
        return product;
    }


    public Product deleteProductById(Product request, Integer id){
        Product product = productRp.findById(id).get();

        product.setIsDeleted(true);
        product.setDeletedAt(LocalDateTime.now());

        productRp.save(product);

        return product;
    }

   
}
