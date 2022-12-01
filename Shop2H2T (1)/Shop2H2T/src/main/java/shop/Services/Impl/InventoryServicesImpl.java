package shop.Services.Impl;

import shop.DAO.Impl.InventoryDAOImpl;
import shop.Services.IIventoryServices;

public class InventoryServicesImpl implements IIventoryServices{

	InventoryDAOImpl inventoryDAOImpl = new InventoryDAOImpl(); 
	
	@Override
	public void insertInventory(int productId, int storeId, int amount) {
		inventoryDAOImpl.insertInventory(productId, storeId, amount);
	}

	@Override
	public void deleteInventory(int productId, int storeId) {
		inventoryDAOImpl.deleteInventory(productId, storeId);
	}

	@Override
	public void updateInventory(int productId, int amount) {
		inventoryDAOImpl.updateInventory(productId, amount);
	}

	@Override
	public int findAmount(int productId) {
		return inventoryDAOImpl.findAmount(productId);
	}
	
}
