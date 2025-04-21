package nogrp.emsCRUD.service;

import java.util.List;

import nogrp.emsCRUD.dto.ProductDto;

public interface ProductService {
    ProductDto createEmployee(ProductDto employeeDto);
    ProductDto getEmployeeId(Long employeeId);
    List<ProductDto> getAllEmployees();
    List<ProductDto> getMaxPrice();
    List<Long> getYearMaxPrice();
    // List<ProductDto> getUniqueProdPrice();
    // List<ProductDto> 
    ProductDto updateEmployee(Long employeeId, ProductDto updatedEmployee);
}
