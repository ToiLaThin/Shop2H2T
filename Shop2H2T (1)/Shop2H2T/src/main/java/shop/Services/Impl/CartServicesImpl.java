package shop.Services.Impl;

import java.util.List;

import shop.DAO.Impl.CartDAOImpl;
import shop.Models.CartModel;
import shop.Services.ICartServices;


public class CartServicesImpl implements ICartServices{
	CartDAOImpl cartDAO = new CartDAOImpl();
	@Override
	public List<CartModel> findAllWaiting() {
		return cartDAO.findAllWaiting();
	}

	@Override
	public List<CartModel> findAllValid() {
		return cartDAO.findAllValid();
	}

	@Override
	public List<CartModel> findAllInValid() {
		return cartDAO.findAllInValid();
	}

	@Override
	public int findCartId(int userId, String phoneNumber, String address) {
		return cartDAO.findCartId(userId, phoneNumber, address);
	}

	@Override
	public void insertNewCart(CartModel cart) {
		cartDAO.insertNewCart(cart);
	}

	@Override
	public List<CartModel> findAllWaitingOfUser(int userId) {
		return cartDAO.findAllWaitingOfUser(userId);
	}

	@Override
	public List<CartModel> findAllValidOfUser(int userId) {
		return cartDAO.findAllValidOfUser(userId);
	}

	@Override
	public List<CartModel> findAllInValidOfUser(int userId) {
		return cartDAO.findAllInValidOfUser(userId);
	}

	@Override
	public void changeStatusToValid(int cartId) {
		cartDAO.changeStatusToValid(cartId);
		
	}

	@Override
	public void changeStatusToInValid(int cartId) {
		cartDAO.changeStatusToInValid(cartId);
	}

	@Override
	public void changeStatusToCheckedOut(int cartId) {
		cartDAO.changeStatusToCheckedOut(cartId);
	}

	@Override
	public List<CartModel> findAllCheckOutedOfUser(int userId) {
		return cartDAO.findAllCheckOutedOfUser(userId);
	}
	
	
	

}
