package com.hcprogramer.ecommerce.controllers;

import com.hcprogramer.ecommerce.common.ApiResponse;
import com.hcprogramer.ecommerce.model.Category;
import com.hcprogramer.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PatchMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "Category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "Created the category"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>>getCategories(){
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(Body, HttpStatus.OK);
    }

    @PatchMapping("/update/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID")Integer categoryID,
                                                      @Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(categoryID))) {
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Updated the category"),HttpStatus.OK);
        }

        return new ResponseEntity<>(new ApiResponse(false, "Category does not exits"), HttpStatus.NOT_FOUND);
    }
}
