package com.article.admin.service;

import java.util.List;

import com.article.admin.entity.Category;

public interface ICategoryService {
	boolean createCategory(Category category);
	 List<Category> getAllCategory();
	 void updateCategory(Category category);
	 void deleteCategory(int categoryId);
	 Category getCategoryById(int categoryId);
	
}
