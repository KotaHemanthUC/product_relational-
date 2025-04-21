package nogrp.emsCRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductYearDto {
    private Long id;
    private String product;
    private long price;
    private long year;
}
