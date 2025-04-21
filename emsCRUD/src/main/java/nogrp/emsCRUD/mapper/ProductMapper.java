package nogrp.emsCRUD.mapper;

import nogrp.emsCRUD.dto.ProductDto;
import nogrp.emsCRUD.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProdDto(Product prod_price){
        return new ProductDto(
            prod_price.getId(),
            prod_price.getProduct(),
            prod_price.getVersion(),
            prod_price.getYear(),
            prod_price.getPrice()
        );
    }
    public static Product mapToProduct(ProductDto prodDto){
        return new Product(
                prodDto.getId(),
                prodDto.getProduct(),
                prodDto.getVersion(),
                prodDto.getYear(),
                prodDto.getPrice()
        );
    }
}
