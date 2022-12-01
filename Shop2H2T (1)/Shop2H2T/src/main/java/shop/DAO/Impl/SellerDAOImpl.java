package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.Connection.DbConnection;
import shop.DAO.ISellerDAO;

public class SellerDAOImpl extends DbConnection implements ISellerDAO{

	@Override
	public void insertSeller(String sellerName,int storeId) {
		Connection conn = null;
		try {
			//2 là user mặc định sau khi đăng ký có role là user
			String sql = "Insert Into Seller(sellername,status,id_Seller_Store) Values (?,1,?)";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sellerName);		
			ps.setInt(2, storeId);
			ps.executeUpdate();			
		}
		catch (Exception e) {
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
	public int findSellerId(String sellerName) {
		Connection conn = null;
		try {
			//2 là user mặc định sau khi đăng ký có role là user
			String sql = "Select sellerId From Seller Where sellername = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sellerName);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("sellerId");
			}
		}
		catch (Exception e) {
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
		return 0;
	}

	@Override
	public int findStoreId(int sellerId) {
		Connection conn = null;
		try {
			String sql = "Select id_Seller_Store From Seller Where sellerId = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerId);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("id_Seller_Store");
			}
		}
		catch (Exception e) {
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
		return 0;
	}
	
	

}
