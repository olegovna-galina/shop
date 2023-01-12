package com.solutions.shop.mapping;

import com.solutions.shop.dto.ProductDto;
import com.solutions.shop.model.Product;

public class MappingProduct {

    public ProductDto mapToProductDto(Product entity) {
        ProductDto dto = new ProductDto();
        dto.setProductId(entity.getProductId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setBrand(entity.getBrand());
        dto.setCategory(entity.getCategory());
        return dto;
    }

    public Product mapToProduct(ProductDto dto) {
        Product entity = new Product();
        entity.setProductId(dto.getProductId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setBrand(dto.getBrand());
        entity.setCategory(dto.getCategory());
        return entity;
    }
}
