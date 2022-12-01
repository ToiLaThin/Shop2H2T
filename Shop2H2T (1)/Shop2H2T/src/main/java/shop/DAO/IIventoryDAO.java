package shop.DAO;

public interface IIventoryDAO {	
	void insertInventory(int productId,int storeId,int amount);
	void deleteInventory(int productId,int storeId);
	//vì 1 productId chỉ ứng với 1 store nên ko cần thêm storeId
	void updateInventory(int productId,int amount);
	int findAmount(int productId);
}
