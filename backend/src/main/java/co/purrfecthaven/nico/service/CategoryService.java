package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Category createCategory (Category category){
        return categoryRp.save(category);
    }

    public Category updateCategory (Category request, Integer id){
        Category category = categoryRp.findById(id).get();

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        categoryRp.save(category);
        return category;
    }


    public Category deleteCategoryById(Category request, Integer id){
        Category category = categoryRp.findById(id).get();

        category.setIsDeleted(true);
        category.setDeletedAt(LocalDateTime.now());

        categoryRp.save(category);

        return category;
    }

    

}
