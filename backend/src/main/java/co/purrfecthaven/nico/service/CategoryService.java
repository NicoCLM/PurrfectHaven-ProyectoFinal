package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.CategoryDTO;
import co.purrfecthaven.nico.model.Category;
import co.purrfecthaven.nico.repository.CategoryRepository;

/**
 * CategoryService
 */

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRp;

    public ArrayList<Category> getAll(){
        return (ArrayList<Category>) categoryRp.findAll();
    }

    public Category createCategory (CategoryDTO categoryDTO){
        Category category = new Category();
        
        category.setCreatedAt(LocalDateTime.now());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        
        categoryRp.save(category);
        return category;
    }

    public Category updateCategory (CategoryDTO request, Integer id){
        Category category = categoryRp.findById(id).get();

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        categoryRp.save(category);
        return category;
    }


    public Category deleteCategoryById(Integer id){
        Category category = categoryRp.findById(id).get();

        category.setIsDeleted(true);
        category.setDeletedAt(LocalDateTime.now());

        categoryRp.save(category);

        return category;
    }

    

}
