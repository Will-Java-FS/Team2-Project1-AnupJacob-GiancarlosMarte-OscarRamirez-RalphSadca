package com.revature.Services;

import com.revature.Models.Category;
import com.revature.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepo cr;

    @Autowired
    private CategoryService(CategoryRepo cr){
        this.cr = cr;
    }

    // CLIENT SERVICE
    public List<Category> getAllCategories(){
        return cr.findAll();
    }

//    public Optional<Category> findById(int id) {
//        return cr.findById(id);
//    }
public Category findById(int id) {
    return cr.findById(id);
}

    // ADMIN SERVICE
    public Category addCategory(Category category){
        return cr.save(category);
    }

}
