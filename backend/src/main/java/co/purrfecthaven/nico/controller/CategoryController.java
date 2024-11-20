package co.purrfecthaven.nico.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.CategoryDTO;
import co.purrfecthaven.nico.model.Category;
import co.purrfecthaven.nico.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * CategoryController
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Category>> listCategory() {
        try {
            ArrayList<Category> getCategory = this.categoryService.getAll();
            return ResponseEntity.ok(getCategory);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO categoryDTO){
        try {
            Category createdCategory = this.categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoryById(@RequestBody CategoryDTO request, @PathVariable("id") Integer id){
        try {
            Category updatedCategory = this.categoryService.updateCategory(request, id);
            return ResponseEntity.ok(updatedCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Integer id){
        try {
            Category deletedCategory = this.categoryService.deleteCategoryById(id);
            return ResponseEntity.ok(deletedCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }

}
