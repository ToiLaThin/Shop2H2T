package shop.Services;

public interface ISellerServices {
	void insertSeller(String sellerName, int storeId);
	int findSellerId(String sellerName);
	int findStoreId(int sellerId);
}
