package nogrp.emsCRUD.mapper;

import nogrp.emsCRUD.dto.ProductYearDto;
import nogrp.emsCRUD.entity.ProductYear;

public class ProductYearMapper {
    public static ProductYearDto mapToProdDto(ProductYear prodyrobj){
        return new ProductYearDto(
            prodyrobj.getId(),
            prodyrobj.getProduct(),
            prodyrobj.getYear(),
            prodyrobj.getPrice()
        );
    }
    public static ProductYear mapToProduct(ProductYearDto prodyrDto){
        return new ProductYear(
                prodyrDto.getId(),
                prodyrDto.getProduct(),
                prodyrDto.getYear(),
                prodyrDto.getPrice()
        );
    }
}
