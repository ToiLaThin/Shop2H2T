package shop.Services;

import java.util.List;

import shop.Models.ProductModel;

public interface IProductServices {
	List<ProductModel> findAll();
	ProductModel find(int productId);
	List<ProductModel> findByCategory(int categoryId);
	List<ProductModel> findBySearch(String searchPhrase);
	
	void insertProduct(ProductModel product);
	void deleteProduct(int productId);
	void editProduct(ProductModel product);
	
	
	List<ProductModel> findAllBySellerId(int sellerId);
	int findProductId(ProductModel product);
}
