package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.Connection.DbConnection;
import shop.DAO.IIventoryDAO;

public class InventoryDAOImpl extends DbConnection implements IIventoryDAO{

	@Override
	public void insertInventory(int productId, int storeId, int amount) {
		Connection conn = null;
		String sql = "Insert Into Inventory(id_Inventory_Store,id_Inventory_Product,amount) Values(?,?,?)";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, storeId);
			ps.setInt(2, productId);
			ps.setInt(3, amount);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally  {           
	        if ( conn != null )
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}  
		}
	}

	@Override
	public void deleteInventory(int productId, int storeId) {
		Connection conn = null;
		String sql = "Delete From Inventory Where id_Inventory_Store = ? And id_Inventory_Product = ?";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, storeId);
			ps.setInt(2, productId);						
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally  {           
	        if ( conn != null )
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}  
		}
	}

	@Override
	public void updateInventory(int productId, int amount) {
		Connection conn = null;
		String sql = "Update Inventory Set amount = ? Where id_Inventory_Product = ?";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, amount);
			ps.setInt(2, productId);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally  {           
	        if ( conn != null )
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}  
		}
	}

	@Override
	public int findAmount(int productId) {
		Connection conn = null;
		String sql = "Select amount From Inventory Where id_Inventory_Product = ?";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, productId);			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("amount");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally  {           
	        if ( conn != null )
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}  
		}
		//nếu sản phẩm ko có trong kho hàng do ko được seller tạo
		return -1;
	}
	
	
}
