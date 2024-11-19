package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.ProductDTO;
import co.purrfecthaven.nico.model.Category;
import co.purrfecthaven.nico.model.Product;
import co.purrfecthaven.nico.repository.CategoryRepository;
import co.purrfecthaven.nico.repository.ProductRepository;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRp;

    @Autowired
    private CategoryRepository categoryRp;

    public ArrayList<Product> getAll(){
        return (ArrayList<Product>) productRp.findAll();
    }

    public Product createProduct (ProductDTO productDTO){
        Product product = new Product();
        Category category = categoryRp.findById(productDTO.getCategoryId()).orElseThrow(()-> new IllegalArgumentException("Categoria no encontrada" + productDTO.getCategoryId()));
        
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategory(category);

        productRp.save(product);
        return product;
    }

    public Product updateProductById (ProductDTO request, Integer id){
        Product product = productRp.findById(id).get();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());

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
