package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.Connection.DbConnection;
import shop.DAO.IReceiptDAO;
import shop.Models.CartModel;
import shop.Models.ProductModel;
import shop.Models.ReceiptModel;

public class ReceiptDAOImpl extends DbConnection implements IReceiptDAO{

	@Override
	public List<ReceiptModel> findAllOfCheckOutedCarts(List<CartModel> checkOutedCartsOfUser) {
		List<ReceiptModel> receipts = new ArrayList<ReceiptModel>();
		String sql = "Select * From Receipt Where cartId = ?";
		Connection conn = null;
		try {
			conn = super.getConnection();
			for(CartModel validCartOfUser : checkOutedCartsOfUser)
			{
				PreparedStatement ps = conn.prepareStatement(sql);
				int validCartOfUserId = validCartOfUser.getCartId();
				ps.setInt(1, validCartOfUserId);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					ReceiptModel receipt= new ReceiptModel();
					receipt.setReceiptId(rs.getInt("receiptId"));
					receipt.setReleaseDate(rs.getDate("releaseDate"));
					receipt.setCartId(rs.getInt("cartId"));
					receipts.add(receipt);
					break;
				}				
			}			
		} catch(Exception e) {
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
		return receipts;
	}

	@Override
	public void insertReceipt(ReceiptModel receipt) {
		Connection conn = null;
		String sql = "Insert Into Receipt(releaseDate,cartId) Values(?,?)";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, receipt.getReleaseDate());
			ps.setInt(2, receipt.getCartId());
			ps.executeUpdate();
		} catch(Exception e) {
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
	public ReceiptModel find(int receiptId) {
		Connection conn = null;
		String sql = "Select * From Receipt Where receiptId = ?";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,receiptId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				{
					ReceiptModel receipt= new ReceiptModel();
					receipt.setReceiptId(rs.getInt("receiptId"));
					receipt.setReleaseDate(rs.getDate("releaseDate"));
					receipt.setCartId(rs.getInt("cartId"));
					return receipt;
				}				
			}			
		} catch(Exception e) {
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
		return null;
	}

}
