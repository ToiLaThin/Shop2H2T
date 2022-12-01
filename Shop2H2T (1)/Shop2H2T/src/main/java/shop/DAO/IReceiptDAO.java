package shop.DAO;

import java.util.List;

import shop.Models.CartModel;
import shop.Models.ReceiptModel;

public interface IReceiptDAO {
	List<ReceiptModel> findAllOfCheckOutedCarts(List<CartModel> checkOutedCartsOfUser);
	ReceiptModel find(int receiptId);
	void insertReceipt(ReceiptModel receipt);
}
