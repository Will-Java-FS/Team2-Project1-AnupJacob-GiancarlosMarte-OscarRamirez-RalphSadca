package com.revature.Repositories;


import com.revature.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findProductsByCategory(String category);

    /*
    Stretch Goal: Functions for searching product by name and price
    - useful for a filter menu on the front end

    public List<Product> findProductsByTitle(String title);
    public List<Product> findProductsByMoney(BigDecimal money);

    @Query("From Product WHERE title=:title AND money=:money")
    public List<Product> findProductsByTitleAndPrice(@Param("title") String title,
                                                     @Param("money") BigDecimal money);
    */
}
