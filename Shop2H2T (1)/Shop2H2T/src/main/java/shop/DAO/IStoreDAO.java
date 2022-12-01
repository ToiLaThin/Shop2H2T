package shop.DAO;

import java.sql.Date;

public interface IStoreDAO {
	void insertStore(String storeName, Date storeDate);
	int findStoreId(String storeName);
}
