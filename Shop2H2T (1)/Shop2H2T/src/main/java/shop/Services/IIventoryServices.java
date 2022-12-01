package shop.Services;

public interface IIventoryServices {
	void insertInventory(int productId,int storeId,int amount);
	void deleteInventory(int productId,int storeId);
	void updateInventory(int productId,int amount);
	int findAmount(int productId);
}
