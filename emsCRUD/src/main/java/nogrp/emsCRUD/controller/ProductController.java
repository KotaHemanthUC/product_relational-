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
    public ResponseEntity<ProductDto> createProd(@RequestBody ProductDto productDto){
        ProductDto savedProduct = prodService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long prodId){
        ProductDto prodDto = prodService.getProductId(prodId);
        return ResponseEntity.ok(prodDto);
    }

    @GetMapping("/maxproductprice")
    public ResponseEntity<List<Long>> getMaxProdPrice() {
        System.out.println("=== Max Product Price ===");
        List<Long> uniqProd = prodService.getMaxPrice();
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

    @GetMapping("/UniqueProdPrice")
    public ResponseEntity<List<ProductDto>> getProdPriceLatestYear() {
        // public ResponseEntity<var> getYearMax() {
            System.out.println("=== Unique Product Price ===");
            var uniqProdPrice = prodService.getUniqueProdPrice();
            // System.out.println();
            // System.out.println("========: "+uniqProds.getClass().getSimpleName());
            // List<ProductDto> uniqProds = prodService.getYearMaxPrice();
            //  = prodService.getUniqueProdPrice();
            return ResponseEntity.ok(uniqProdPrice);
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        System.out.println("=== Print All ===");
        List<ProductDto> products = prodService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long prodId,
                                                      @RequestBody ProductDto updatedProd){
       ProductDto prodDto = prodService.updateProduct(prodId, updatedProd);
       return ResponseEntity.ok(prodDto);
    }

}
