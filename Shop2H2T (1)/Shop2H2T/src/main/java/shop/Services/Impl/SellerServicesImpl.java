package shop.Services.Impl;

import shop.DAO.Impl.SellerDAOImpl;
import shop.Services.ISellerServices;

public class SellerServicesImpl implements ISellerServices{

	SellerDAOImpl sellerDAOImpl = new SellerDAOImpl();
	
	@Override
	public void insertSeller(String sellerName,int storeId) {
		sellerDAOImpl.insertSeller(sellerName,storeId);
	}

	@Override
	public int findSellerId(String sellerName) {
		return sellerDAOImpl.findSellerId(sellerName);
	}

	@Override
	public int findStoreId(int sellerId) {
		return sellerDAOImpl.findStoreId(sellerId);
	}
	
}
