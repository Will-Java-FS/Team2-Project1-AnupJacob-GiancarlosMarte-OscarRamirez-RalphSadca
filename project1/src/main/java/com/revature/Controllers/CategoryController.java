//package com.revature.Controllers;
//
//import com.revature.Models.Category;
//import com.revature.Services.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CategoryController {
//
//    CategoryService cs;
//
//    @Autowired
//    private CategoryController(CategoryService cs){
//        this.cs = cs;
//    }
//
//    @RequestMapping(method= RequestMethod.POST, value="/category")
//    public ResponseEntity<Category> addCategory(@RequestBody Category category){
//        Category newCategory = cs.addCategory(category);
//        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(method=RequestMethod.GET, value="/category")
//    public ResponseEntity<List<Category>> getAllCategories(){
//        List<Category> categories = cs.getAllCategories();
//        return new ResponseEntity<>(categories, HttpStatus.OK);
//    }
//}