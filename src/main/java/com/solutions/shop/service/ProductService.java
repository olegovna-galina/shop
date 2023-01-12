package com.solutions.shop.service;

import com.solutions.shop.dto.ProductDto;
import com.solutions.shop.mapping.MappingProduct;
import com.solutions.shop.model.Product;
import com.solutions.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository iProductRepository;

    /**
     *
     * add Product (for admin)
     *
     * @param productDto ProductDto
     * @return productDto ProductDto
     */
    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        if (productDto.getProductId() != null) {
            MappingProduct mapping = new MappingProduct();
            Product product = mapping.mapToProduct(productDto);
            iProductRepository.save(product);
            return productDto;
        }
        return null;
    }
}
