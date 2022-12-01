package shop.Services.Impl;

import java.util.List;

import shop.DAO.Impl.CategoryDAOImpl;
import shop.Models.CategoryModel;
import shop.Services.ICategoryServices;

public class CategoryServicesImpl implements ICategoryServices{
	
	CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public void insertCategory(CategoryModel category) {
		categoryDAO.insertCategory(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}

	@Override
	public void editCategory(CategoryModel category) {
		categoryDAO.editCategory(category);
	}

	@Override
	public CategoryModel find(int categoryId) {
		return categoryDAO.find(categoryId);
	}

}
