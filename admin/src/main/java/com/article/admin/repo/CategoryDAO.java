package com.article.admin.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.article.admin.entity.Category;

@Transactional
@Repository

public class CategoryDAO implements ICategoryDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public void createCategory(Category category) {
		
		entityManager.persist(category);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		String hql = "FROM Category as atcl ORDER BY atcl.categoryId DESC";
		return (List<Category>) entityManager.createQuery(hql).getResultList();
	
	}

	@Override
	public void updateCategory(Category category) {
		Category artcl = getCategoryById(category.getCategoryId());
		artcl.setCategoryname(category.getCategoryname());
		entityManager.flush();
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		entityManager.remove(getCategoryById(categoryId));
	}

	@Override
	public Category getCategoryById(int categoryId) {
		return entityManager.find(Category.class, categoryId);

	}

	
	@Override
	public boolean categoryExists(String category) {
		String hql = "FROM Category as c WHERE c.categoryname =: category";
		int count = entityManager.createQuery(hql).setParameter("category",category).getResultList().size();
	return count > 0 ? true : false;

	}

}
