package shop.Services.Impl;

import java.util.List;

import shop.DAO.Impl.CartItemDAOImpl;
import shop.Models.CartItemModel;
import shop.Services.ICartItemServices;


public class CartItemServicesImpl implements ICartItemServices{
	CartItemDAOImpl cartItemDAO = new CartItemDAOImpl();
	@Override
	public void insertToCart(CartItemModel cartItem) {
		cartItemDAO.insertToCart(cartItem);
	}

	@Override
	public List<CartItemModel> findAllByCartId(int cartId) {
		// TODO Auto-generated method stub
		return cartItemDAO.findAllByCartId(cartId);
	}

}
