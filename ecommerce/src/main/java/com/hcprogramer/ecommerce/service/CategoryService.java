package com.hcprogramer.ecommerce.service;

import com.hcprogramer.ecommerce.model.Category;
import com.hcprogramer.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Object readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
