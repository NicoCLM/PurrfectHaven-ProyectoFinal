package co.purrfecthaven.nico.exception;

/**
 * ProductNotFoundException
 */
public class ProductNotFoundException extends RuntimeException{
    
    public ProductNotFoundException(String message){
        super(message);
    }
}
