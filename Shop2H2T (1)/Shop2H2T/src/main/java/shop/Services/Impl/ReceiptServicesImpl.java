package shop.Services.Impl;

import java.util.List;

import shop.DAO.Impl.ReceiptDAOImpl;
import shop.Models.CartModel;
import shop.Models.ReceiptModel;
import shop.Services.IReceiptServices;

public class ReceiptServicesImpl implements IReceiptServices{

	ReceiptDAOImpl receiptDaoImpl = new ReceiptDAOImpl();
	
	@Override
	public List<ReceiptModel> findAllOfCheckOutedCarts(List<CartModel> checkOutedCartsOfUser) {
		return receiptDaoImpl.findAllOfCheckOutedCarts(checkOutedCartsOfUser);
	}

	@Override
	public void insertReceipt(ReceiptModel receipt) {
		receiptDaoImpl.insertReceipt(receipt);
	}

	@Override
	public ReceiptModel find(int receiptId) {
		return receiptDaoImpl.find(receiptId);
	}
	
}
