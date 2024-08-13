package com.revature.Controllers;

import com.revature.Models.Product;
import com.revature.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductService ps;

    @Autowired
    private ProductController(ProductService ps){
        this.ps = ps;
    }

    @RequestMapping(method=RequestMethod.GET, value="/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product retrievedProduct =  ps.getProductById(id);
        return retrievedProduct==null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(retrievedProduct, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET, value="/products")
    public List<Product> getAllProducts(){
        return ps.getAllProducts();
    }

    @RequestMapping(method=RequestMethod.GET, value="products/{category_id}")
    public List<Product> getAllProductsByCategory(@PathVariable int category_id){
        return ps.getProductsByCategory(category_id);
    }
}