package shop.DAO;

import java.util.List;

import shop.Models.AccountModel;
import shop.Models.ProductModel;

public interface IAccountDAO {
	boolean authenticateAccount(String username, String password);
	String findRoleAccount(String username, String password);
	void registerAccount(String username, String password);
	void registerAccount(AccountModel account);
	void becomeSeller(int sellerId,String username);
	int findSellerId(String username);
	int findAccountId(String username);
	List<AccountModel> findAll();
	AccountModel findById(int id);
	void changeStatus(int id,int status);
}
