package nogrp.emsCRUD.service.implementation;

import java.util.stream.Collectors;
import java.util.*;
 
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nogrp.emsCRUD.dto.ProductDto;
import nogrp.emsCRUD.entity.Product;
import nogrp.emsCRUD.exception.ResourceNotFoundException;
import nogrp.emsCRUD.mapper.ProductMapper;
import nogrp.emsCRUD.repository.ProductRepository;
import nogrp.emsCRUD.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceimpl implements ProductService {
    private ProductRepository prodRepository;
    @Override
    public ProductDto createProduct(ProductDto prodDto) {
        Product product = ProductMapper.mapToProduct(prodDto);
        Product savedProd = prodRepository.save(product);
        return (ProductMapper.mapToProdDto(savedProd));
    }

    @Override
    public ProductDto getProductId(Long productId) {
        Product product = prodRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product dosen't exist with given ID"+productId));
        return (ProductMapper.mapToProdDto(product));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> prods = prodRepository.findAll();
        return prods.stream().map(prod -> ProductMapper.mapToProdDto(prod))
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getMaxPrice(){
        System.out.println("---- getMaxPrice ---");

        var yearPrice = prodRepository.findMaxPrice();
        System.out.println("===> year: "+yearPrice.size());
        // List<ProductDto> retyearProds = yearProds.stream().map(prod -> ProductMapper.mapToProdDto(prod))
                            // .collect(Collectors.toList());
        // System.out.println("=== year sz ==="+retyearProds.size());
        return yearPrice;

        // List<Product> prods = prodRepository.findAll();
        // // return prods.stream().map();
        // List<ProductDto > dtoProds = prods.stream().map(prod -> ProductMapper.mapToProdDto(prod))
        // .collect(Collectors.toList());
        // // ProductDto maxProd;
        // long maxPrice = dtoProds.get(0).getPrice();
        // int maxIndex = 0;
        // for(int i=1; i<dtoProds.size(); i++){
        //     if ( maxPrice < dtoProds.get(i).getPrice() ){
        //         maxIndex = i;
        //     }
        // }
        // System.out.println("maxIndex ===>:"+ maxIndex);
        // return dtoProds.get(maxIndex);
    }

    // @Override
    // public ProductDto getUniqueProductPrice(){
    //     System.out.println("---- uniqueProdPrice ---");
    //     List<Product> prods = prodRepository.findAll();
    //     // return prods.stream().map();
    //     List<ProductDto > dtoProds = prods.stream().map(prod -> ProductMapper.mapToProdDto(prod))
    //     .collect(Collectors.toList());
    //     // ProductDto maxProd;
    //     long maxPrice = dtoProds.get(0).getYear();
    //     int maxIndex = 0;
    //     for(int i=1; i<dtoProds.size(); i++){
    //         if ( maxPrice < dtoProds.get(i).getPrice() ){
    //             maxIndex = i;
    //         }
    //     }
    //     System.out.println("maxIndex ===>:"+ maxIndex);
    //     return dtoProds.get(maxIndex);
    // }

    

    @Override
    public List<Long> getYearMaxPrice(){
        var yearProds = prodRepository.findMaxPriceByYear();
        System.out.println("===> year: "+yearProds.size());
        // List<ProductDto> retyearProds = yearProds.stream().map(prod -> ProductMapper.mapToProdDto(prod))
                            // .collect(Collectors.toList());
        // System.out.println("=== year sz ==="+retyearProds.size());
        return yearProds;
    }

    @Override
    public List<ProductDto> getUniqueProdPrice(){
        var upriceProds = prodRepository.findProductPrice();
        System.out.println("===> ProdPrice: "+upriceProds.size());
        return upriceProds.stream().map(prod -> ProductMapper.mapToProdDto(prod))
                .collect(Collectors.toList());
        // return upriceProds;
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product prod = prodRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product doesnt exist with given ID:"+productId)
        );
        prod.setProduct(updatedProduct.getProduct());
        prod.setPrice(updatedProduct.getPrice());
        prod.setYear(updatedProduct.getYear());
        prod.setVersion(updatedProduct.getVersion());

        Product updatedProdObj = prodRepository.save(prod);

        return ProductMapper.mapToProdDto(updatedProdObj);
    }

}
