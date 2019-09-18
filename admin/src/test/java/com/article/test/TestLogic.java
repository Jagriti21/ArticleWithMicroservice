package com.article.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.article.admin.entity.Category;
import com.article.admin.service.ICategoryService;

public class TestLogic {
	@Autowired
	private ICategoryService i;
	  @Test  
	    public void testFindCategory(){  
		  Category cat = new Category();
		  cat=i.getCategoryById(11);
		  String yes = cat.getCategoryname();
		  System.out.println(yes);
		  String category="Horror";
		  assertEquals(category,category);
		  //  i assertNotNull(i.getCategoryById(categoryId));
	      //  assertEquals(4,i.getCategoryById(categoryId));  
	       // assertEquals(-1,Calculation.findMax(new int[]{-12,-1,-3,-4,-2}));  
	    }  
}
