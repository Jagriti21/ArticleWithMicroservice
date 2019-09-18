package com.article.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.article.admin.entity.Category;
import com.article.admin.entity.User;
import com.article.admin.entity.UserLogin;
import com.article.admin.repo.UserRepo;
import com.article.admin.service.ICategoryService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private ICategoryService  categoryService;
	@SuppressWarnings("unused")

	 @PostMapping(path = "/login")
	    public User login(@RequestBody UserLogin userlogin){
		 User u = new User();
		 System.out.println(userlogin.getUsername());
		 System.out.println(userlogin.getPassword());
	     if(userlogin.getUsername().equalsIgnoreCase("admin") && userlogin.getPassword().equalsIgnoreCase("admin")) {
	    	
	    	u.setStatus(1);
	    	return u;
	     }
	     else {
	    	 u.setStatus(0);
	      return u;
	     }
	    }
	@GetMapping("all-category")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> list = categoryService.getAllCategory();
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	@GetMapping("category")
	public ResponseEntity<Category> getCategoryById(@RequestParam("id") String id) {
		
		Category category = categoryService.getCategoryById(Integer.parseInt(id));
		return new ResponseEntity<Category>(category, HttpStatus.OK);
		
	}
	@PutMapping("category")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	@DeleteMapping("category")
	public ResponseEntity<Void> deleteCategory(@RequestParam("id") String id) {
		categoryService.deleteCategory(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	@PostMapping("category")
	public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder builder) {
		System.out.println("hello");
        boolean flag = categoryService.createCategory(category);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/category?id={id}").buildAndExpand(category.getCategoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
