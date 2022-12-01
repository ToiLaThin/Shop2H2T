package shop.DAO;

public interface ISellerDAO {
	void insertSeller(String sellerName,int storeId);
	int findSellerId(String sellerName);
	int findStoreId(int sellerId);
}
