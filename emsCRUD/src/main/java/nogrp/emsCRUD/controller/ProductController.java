package nogrp.emsCRUD.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nogrp.emsCRUD.dto.ProductDto;
import nogrp.emsCRUD.service.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService prodService;
    @PostMapping
    public ResponseEntity<ProductDto> createEmployee(@RequestBody ProductDto employeeDto){
        ProductDto savedEmployee = prodService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getEmployeeById(@PathVariable("id") Long employeeId){
        ProductDto prodDto = prodService.getEmployeeId(employeeId);
        return ResponseEntity.ok(prodDto);
    }

    // @GetMapping("/max")
    // public ResponseEntity<ProductDto> getMaxEmployee() {
    //     System.out.println("=== Max is hit ===");
    //     ProductDto maxProd = prodService.getMaxPrice();
    //     return ResponseEntity.ok(maxProd);
    // }

    @GetMapping("/maxproductprice")
    public ResponseEntity<List<ProductDto>> getMaxProdPrice() {
        System.out.println("=== Max Product Price ===");
        List<ProductDto> uniqProd = prodService.getMaxPrice();
        System.out.println("++++"+ uniqProd.size());
        return ResponseEntity.ok(uniqProd);
    }

    @GetMapping("/yearmax")
    public ResponseEntity<List<Long>> getYearMax() {
    // public ResponseEntity<var> getYearMax() {
        System.out.println("=== Max Year Price ===");
        var uniqProds = prodService.getYearMaxPrice();
        // System.out.println();
        System.out.println("========: "+uniqProds.getClass().getSimpleName());
        // List<ProductDto> uniqProds = prodService.getYearMaxPrice();
        //  = prodService.getUniqueProdPrice();
        return ResponseEntity.ok(uniqProds);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllEmployees(){
        System.out.println("=== Print All ===");
        List<ProductDto> employees = prodService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody ProductDto updatedEmployee){
       ProductDto employeeDto = prodService.updateEmployee(employeeId, updatedEmployee);
       return ResponseEntity.ok(employeeDto);
    }

}
