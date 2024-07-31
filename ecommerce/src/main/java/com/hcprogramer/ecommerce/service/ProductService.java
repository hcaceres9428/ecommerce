package com.hcprogramer.ecommerce.service;

import com.hcprogramer.ecommerce.dto.product.ProductDto;
import com.hcprogramer.ecommerce.model.Category;
import com.hcprogramer.ecommerce.model.Product;
import com.hcprogramer.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductoDto(productDto, category);
        productRepository.save(product);
    }

    private Product getProductoDto(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }
}
