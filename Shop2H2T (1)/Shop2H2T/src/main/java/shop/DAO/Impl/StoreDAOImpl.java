package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.Connection.DbConnection;
import shop.DAO.IStoreDAO;

public class StoreDAOImpl extends DbConnection implements IStoreDAO{

	@Override
	public void insertStore(String storeName, Date storeDate) {
		Connection conn = null;
		try {
			String sql = "Insert Into Store(storeName,storeDate) Values (?,?)";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, storeName);			
			ps.setDate(2, storeDate);			
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
	public int findStoreId(String storeName) {
		Connection conn = null;
		try {
			//2 là user mặc định sau khi đăng ký có role là user
			String sql = "Select storeId From Store Where storeName = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, storeName);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("storeId");
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
