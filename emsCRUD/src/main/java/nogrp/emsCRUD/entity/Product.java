package nogrp.emsCRUD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
// @NamedNativeQuery(name = "Product.findDistinctYears",
                //   query = "SELECT * FROM products as p INNER JOIN (  SELECT PYear, MAX(Price) AS max_price FROM products GROUP BY PYear) AS inner_max_table ON p.PYear = inner_max_table.PYear AND p.Price = inner_max_table.max_price ORDER BY p.PYear",
                //   resultSetMapping = "dto.ProductDto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product")
    private String product;
    @Column(name = "version")
    private Long version;

    @Column(name = "pyear")
    private Long year;

    @Column(name = "price")
    private Long price;
}

