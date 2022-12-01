package shop.Services.Impl;

import java.sql.Date;

import shop.DAO.Impl.StoreDAOImpl;
import shop.Services.IStoreServices;

public class StoreServicesImpl implements IStoreServices{

	StoreDAOImpl storeDAOImpl = new StoreDAOImpl();
	
	@Override
	public void insertStore(String storeName, Date storeDate) {
		storeDAOImpl.insertStore(storeName, storeDate);
	}

	@Override
	public int findStoreId(String storeName) {
		return storeDAOImpl.findStoreId(storeName);
	}

}
