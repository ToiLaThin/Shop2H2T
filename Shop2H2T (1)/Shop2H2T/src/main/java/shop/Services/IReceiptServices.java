package shop.Services;

import java.util.List;

import shop.Models.CartModel;
import shop.Models.ReceiptModel;

public interface IReceiptServices {
	List<ReceiptModel> findAllOfCheckOutedCarts(List<CartModel> checkOutedCartsOfUser);
	void insertReceipt(ReceiptModel receipt);
	ReceiptModel find(int receiptId);
}
