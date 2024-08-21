package com.revature.Services;

import com.revature.Models.Product;
import com.revature.Repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo pr;

    @Autowired
    ProductService(ProductRepo pr){
        this.pr = pr;
    }

    // CLIENT SERVICE(S)
    public List<Product> getAllProducts(){
        return pr.findAll();
    }

    public List<Product> getProductsByCategoryId(int category_id){
        return pr.findProductsByCategoryId(category_id);
    }

    // ADMIN SERVICE(S)
    public Product getProductById(int id){
        return pr.findById(id).orElse(null);
    }

    public Product addNewProduct(Product product){
        return pr.save(product);
    }

    public void deleteProductById(int id){
        pr.deleteById(id);
    }

    @Transactional
    public void deleteProductByTitle(String title) {pr.deleteByTitle(title);
    }
}
