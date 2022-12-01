package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.Connection.DbConnection;
import shop.DAO.ICartItemDAO;
import shop.Models.CartItemModel;
import shop.Models.ProductModel;

public class CartItemDAOImpl extends DbConnection implements ICartItemDAO {

	@Override
	public void insertToCart(CartItemModel cartItem) {
		Connection conn = null;
		String sql = "Insert Into CartItem(quantity,unitPrice,productId,cartId) Values(?,?,?,?)";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, cartItem.getQuantity());
			ps.setFloat(2, cartItem.getUnitPrice());
			ps.setInt(3, cartItem.getProductId());
			ps.setInt(4, cartItem.getCartId());
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
	public List<CartItemModel> findAllByCartId(int cartId) {
		Connection conn = null;
		List<CartItemModel> cartItems = new ArrayList<CartItemModel>();
		String sql = "Select * From CartItem Where cartId = ?";
		
		//cột nào là số thì mặc định là 0
		//cột nào là String hoặc Date thì mặc định là null
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				CartItemModel cartItem = new CartItemModel();
				cartItem.setCartItemId(rs.getInt("cartItemId"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getFloat("unitPrice"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItems.add(cartItem);
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
		return cartItems;
	}

}
