package com.hcprogramer.ecommerce.dto.product;

import com.hcprogramer.ecommerce.model.Product;

import javax.validation.constraints.NotNull;

public class ProductDto {

    private Integer id;
    private @NotNull String name;
    private @NotNull String imageUrl;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;

    public ProductDto(String name, String imageUrl, double price, String description, Integer categoryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setImageUrl(product.getImageUrl());
        this.setPrice(product.getPrice());
        this.setDescription(product.getDescription());
        this.setCategoryId(product.getCategory().getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull double price) {
        this.price = price;
    }

    public @NotNull Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull Integer categoryId) {
        this.categoryId = categoryId;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }
}
