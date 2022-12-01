package shop.DAO;

import java.util.List;

import shop.Models.CategoryModel;
import shop.Models.ProductModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel find(int categoryId);
	void insertCategory(CategoryModel category);
	void deleteCategory(int categoryId);
	void editCategory(CategoryModel category);
}
