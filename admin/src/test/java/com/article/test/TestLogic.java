package com.article.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.article.admin.entity.Category;
import com.article.admin.repo.CategoryDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.article.admin.UserApplication.class)
public class TestLogic {
	@Autowired
	private CategoryDAO i;


@Test
   public void myRepo(){
      List<Category> list = new ArrayList<>();
      list = i.getAllCategory();
      assertEquals(list.get(0).getCategoryname(), "Adventure");
   }


@Test
public void myRepo1(){
   List<Category> list = new ArrayList<>();
   list = i.getAllCategory();
   assertEquals(list.get(1).getCategoryname(), "novel");
}


}
