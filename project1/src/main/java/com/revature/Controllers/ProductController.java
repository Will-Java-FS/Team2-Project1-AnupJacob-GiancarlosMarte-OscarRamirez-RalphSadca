package com.revature.Controllers;

import com.revature.Models.Category;
import com.revature.Models.Product;
import com.revature.Services.CategoryService;
import com.revature.Services.ProductService;
import com.revature.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService ps;
    CategoryService cs;

    @Autowired
    private ProductController(ProductService ps){
        this.ps = ps;
        this.cs=cs;
    }

    // CLIENT CONTROLLER(S)
    @RequestMapping(method=RequestMethod.GET, value="/products")
    public List<Product> getAllProducts(){
        return ps.getAllProducts();
    }

    @RequestMapping(method=RequestMethod.GET, value="/products/{category_id}")
    public List<Product> getAllProductsByCategory(@PathVariable int category_id){
        return ps.getProductsByCategoryId(category_id);
    }


    // ADMIN CONTROLLER(S)
    @RequestMapping(method=RequestMethod.GET, value="/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product retrievedProduct =  ps.getProductById(id);
        return retrievedProduct==null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(retrievedProduct, HttpStatus.OK);
    }

//    @RequestMapping(method=RequestMethod.POST, value="/add-new-product")
//    public Product addNewProduct(@RequestBody Product product){
//        return ps.addNewProduct(product);
//    }

    @RequestMapping(method=RequestMethod.DELETE, value="/delete-product/{id}")
    public void deleteProductById(@PathVariable int id){
        ps.deleteProductById(id);
    }

    @DeleteMapping("/product/{title}")
    public void deleteProductByTitle(@PathVariable String title){ps.deleteProductByTitle(title);}

    @PostMapping("/add-new-product")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        // Handle category lookup and assignment
        Category category = cs.findById(productDto.getCategory_id());
        if (category != null) {
            product.setCategory(category);
        } else {
            // Handle the case where category is not found (optional)
            return ResponseEntity.badRequest().build();
        }

        Product savedProduct = ps.addNewProduct(product);
        return ResponseEntity.ok(savedProduct);
    }





}