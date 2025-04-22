package nogrp.emsCRUD.service;

import java.util.List;

import nogrp.emsCRUD.dto.ProductDto;
import nogrp.emsCRUD.entity.Product;

public interface ProductService {
    ProductDto createProduct(ProductDto prodDto);
    ProductDto getProductId(Long prodId);
    List<ProductDto> getAllProducts();
    List<Long> getMaxPrice();
    List<Long> getYearMaxPrice();
    List<ProductDto> getUniqueProdPrice();
    // List<ProductDto> 
    ProductDto updateProduct(Long productId, ProductDto updatedProduct);
}
