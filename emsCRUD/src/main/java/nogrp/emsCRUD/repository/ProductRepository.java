package nogrp.emsCRUD.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import nogrp.emsCRUD.dto.ProductDto;
import nogrp.emsCRUD.entity.Product;
import nogrp.emsCRUD.entity.ProductYear;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Query findDistinctYears(){
    //     @PersistenceContext
    //     public final EntityManager em = new EntityManager();
    //     String sql = "SELECT * FROM products";
    //     Query query = em.createNativeQuery(sql);
    //     return qeury;
    // }
    // @Query(nativeQuery = true)
    // SELECT *
    // FROM Products AS p
    // WHERE p.Price = (SELECT MAX(Price) FROM Products)""

    @Query(value = "SELECT * FROM products as p WHERE p.price = (SELECT MAX(price) FROM products)", nativeQuery = true)
    List<ProductDto> findMaxPrice();
    // @Query(nativeQuery = true)
    // @Query(value = "SELECT * FROM products as p INNER JOIN (  SELECT PYear, MAX(Price) AS max_price FROM products GROUP BY PYear) AS inner_max_table ON p.PYear = inner_max_table.PYear AND p.Price = inner_max_table.max_price ORDER BY p.PYear", nativeQuery = true)
    // List<ProductDto> findMaxPriceByYear();

    @Query(value = "SELECT p.ID FROM products as p INNER JOIN (  SELECT PYear, MAX(Price) AS max_price FROM products GROUP BY PYear) AS inner_max_table ON p.PYear = inner_max_table.PYear AND p.Price = inner_max_table.max_price ORDER BY p.PYear", nativeQuery = true)
    List<Long> findMaxPriceByYear();

}
