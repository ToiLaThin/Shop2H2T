package shop.Services.Impl;

import java.util.List;

import shop.DAO.Impl.AccountDAOImpl;
import shop.Models.AccountModel;
import shop.Services.IAccountServices;

public class AccountServicesImpl implements IAccountServices{

	AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
	
	@Override
	public boolean authenticateAccount(String username, String password) {
		return accountDAOImpl.authenticateAccount(username, password);
	}

	@Override
	public String findRoleAccount(String username, String password) {
		return accountDAOImpl.findRoleAccount(username, password);
	}

	@Override
	public void registerAccount(String username, String password) {
		accountDAOImpl.registerAccount(username, password);
	}

	@Override
	public void becomeSeller(int sellerId, String username) {
		accountDAOImpl.becomeSeller(sellerId, username);
	}

	@Override
	public int findSellerId(String username) {
		return accountDAOImpl.findSellerId(username);
	}

	@Override
	public int findAccountId(String username) {
		return accountDAOImpl.findAccountId(username);
	}

	@Override
	public List<AccountModel> findAll() {
		// TODO Auto-generated method stub
		return accountDAOImpl.findAll();
	}

	@Override
	public AccountModel findById(int id) {
		// TODO Auto-generated method stub
		return accountDAOImpl.findById(id);
	}

	@Override
	public void changeStatus(int id, int status) {
		accountDAOImpl.changeStatus(id, status);
		
	}

	@Override
	public void registerAccount(AccountModel account) {
		accountDAOImpl.registerAccount(account);
		
	}
	
}
