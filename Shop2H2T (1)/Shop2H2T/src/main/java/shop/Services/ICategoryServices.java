package shop.Services;

import java.util.List;

import shop.Models.CategoryModel;

public interface ICategoryServices {
	List<CategoryModel> findAll();
	void insertCategory(CategoryModel category);
	void deleteCategory(int categoryId);
	void editCategory(CategoryModel category);
	CategoryModel find(int categoryId);
}
