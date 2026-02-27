package ee.jaltdorf.veebipood.controller;

import ee.jaltdorf.veebipood.entity.Category;
import ee.jaltdorf.veebipood.entity.Product;
import ee.jaltdorf.veebipood.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("category")
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    @DeleteMapping("category/{id}")
    public List<Category> deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id); //kustutab
        return categoryRepository.findAll(); //siin on uuenenud seis
    }

    @PostMapping("category")
    public List<Category> addCategory(@RequestBody Category category){
        categoryRepository.save(category); //siin salvestab
        return categoryRepository.findAll(); //siin on uuenenud seis
    }

}
