package shop.Services.Impl;

import java.util.List;

import shop.DAO.Impl.ProductDAOImpl;
import shop.Models.ProductModel;
import shop.Services.IProductServices;

public class ProductServicesImpl implements IProductServices{

	ProductDAOImpl productDAO = new ProductDAOImpl();
	
	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}

	@Override
	public ProductModel find(int productId) {
		return productDAO.find(productId);
	}

	@Override
	public List<ProductModel> findByCategory(int categoryId) {
		return productDAO.findByCategory(categoryId);
	}

	@Override
	public List<ProductModel> findAllBySellerId(int sellerId) {
		return productDAO.findAllBySellerId(sellerId);
	}

	@Override
	public void insertProduct(ProductModel product) {
		productDAO.insertProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}

	@Override
	public void editProduct(ProductModel product) {
		productDAO.editProduct(product);
	}

	@Override
	public int findProductId(ProductModel product) {
		return productDAO.findProductId(product);
	}

	@Override
	public List<ProductModel> findBySearch(String searchPhrase) {
		return productDAO.findBySearch(searchPhrase);
	}
	
	
}
