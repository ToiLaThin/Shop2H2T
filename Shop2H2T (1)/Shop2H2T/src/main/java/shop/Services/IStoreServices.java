package shop.Services;

import java.sql.Date;

public interface IStoreServices {
	void insertStore(String storeName, Date storeDate);
	int findStoreId(String storeName);
}
