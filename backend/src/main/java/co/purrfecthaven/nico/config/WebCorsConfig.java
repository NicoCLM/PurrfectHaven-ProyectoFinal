package co.purrfecthaven.nico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebCorsConfig
 */

@Configuration
public class WebCorsConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**").allowedOrigins("http://localhost:3000", "http://localhost:8080", "http://127.0.0.1:8080")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(false);
    }
    
}
