package shop.Services;

import java.util.List;
import shop.Models.CartItemModel;


public interface ICartItemServices {
	void insertToCart(CartItemModel cartItem);
	List<CartItemModel> findAllByCartId(int cartId);
}
