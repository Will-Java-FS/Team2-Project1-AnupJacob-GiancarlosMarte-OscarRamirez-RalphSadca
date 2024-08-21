package com.revature.Controllers;

import com.revature.Models.Category;
import com.revature.Services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    CategoryService cs;

    @Autowired
    private CategoryController(CategoryService cs){
        this.cs = cs;
    }

    // CLIENT CONTROLLER
    @RequestMapping(method=RequestMethod.GET, value="/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = cs.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
//
//    @GetMapping("/category/{id}")
//    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
//        Optional<Category> category = cs.findById(id);
//        return category.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }

    // ADMIN CONTROLLER
    @RequestMapping(method= RequestMethod.POST, value="/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCategory = cs.addCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }
}
