package com.hcprogramer.ecommerce.service;

import com.hcprogramer.ecommerce.model.Category;
import com.hcprogramer.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Object readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public Optional<Category> readCategory(Integer categoryID){
        return categoryRepository.findById(categoryID);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    private List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public void updateCategory(Integer categoryID, Category newcategory) {
        Category category = categoryRepository.findById(categoryID).get();
        category.setCategoryName(newcategory.getCategoryName());
        category.setDescription(newcategory.getDescription());
        category.setImageUrl(newcategory.getImageUrl());
        categoryRepository.save(category);
    }
}
