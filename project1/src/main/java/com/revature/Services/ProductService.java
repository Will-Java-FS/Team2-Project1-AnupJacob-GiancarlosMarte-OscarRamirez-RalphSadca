package com.revature.Services;

import com.revature.Models.Product;
import com.revature.Repositories.ProductRepo;
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

    public Product getProductById(int id){
        return pr.findById(id).orElse(null);
    }

    public List<Product> getAllProducts(){
        return pr.findAll();
    }

    public List<Product> getProductsByCategory(int category_id){
        return pr.findProductsByCategoryId(category_id);
    }
}
