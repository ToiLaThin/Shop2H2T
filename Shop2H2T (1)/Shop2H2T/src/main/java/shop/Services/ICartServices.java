package shop.Services;

import java.util.List;
import shop.Models.CartModel;


public interface ICartServices {
	List<CartModel> findAllWaiting();
	List<CartModel> findAllValid();
	List<CartModel> findAllInValid();
	List<CartModel> findAllWaitingOfUser(int userId);
	List<CartModel> findAllValidOfUser(int userId);
	List<CartModel> findAllInValidOfUser(int userId);
	List<CartModel> findAllCheckOutedOfUser(int userId);
	int findCartId(int userId,String phoneNumber, String address);
	
	//khi admin duyệt hoặc không
	void changeStatusToValid(int cartId);
	void changeStatusToInValid(int cartId);
	void changeStatusToCheckedOut(int cartId);
	
	//tạo cart
	void insertNewCart(CartModel cart);
}
