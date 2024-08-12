package com.revature.Services;

import com.revature.Models.Category;
import com.revature.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepo cr;

    @Autowired
    private CategoryService(CategoryRepo cr){
        this.cr = cr;
    }

    public Category addCategory(Category category){
        return cr.save(category);
    }

    public List<Category> getAllCategories(){
        return cr.findAll();
    }
}
