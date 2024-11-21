package co.purrfecthaven.nico.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.ProductDTO;
import co.purrfecthaven.nico.exception.ProductNotFoundException;
import co.purrfecthaven.nico.model.Product;
import co.purrfecthaven.nico.service.ProductService;

/**
 * ProductController
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Product>> listProducts(){
        try {
            ArrayList<Product> getProducts = this.productService.getAll();
            return ResponseEntity.ok(getProducts);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO){
        try {
           Product createdProduct = this.productService.createProduct(productDTO); 
           return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado: " + e);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProductById(@RequestBody ProductDTO request, @PathVariable("id") Integer id){
        try {
             Product updatedProduct = this.productService.updateProductById(request, id);
             return ResponseEntity.ok(updatedProduct);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
        
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Integer id){
        try {
            Product deletedProduct = this.productService.deleteProductById(id);
            return ResponseEntity.ok(deletedProduct);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    
}
