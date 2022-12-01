package shop.DAO;

import java.util.List;

import shop.Models.CartItemModel;

public interface ICartItemDAO {
	void insertToCart(CartItemModel cartItem);
	List<CartItemModel> findAllByCartId(int cartId);
}
