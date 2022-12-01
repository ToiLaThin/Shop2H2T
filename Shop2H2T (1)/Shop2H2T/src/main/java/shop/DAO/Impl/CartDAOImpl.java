package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.Connection.DbConnection;
import shop.DAO.ICartDAO;
import shop.Models.CartModel;

public class CartDAOImpl extends DbConnection implements ICartDAO{

	@Override
	public List<CartModel> findAllWaiting() {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where status = 0";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		return null;
	}

	@Override
	public List<CartModel> findAllValid() {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where status = 1";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		return null;
	}

	@Override
	public List<CartModel> findAllInValid() {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where status = -1";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		
		return null;
	}

	@Override
	public int findCartId(int userId, String phoneNumber, String address) {
		Connection conn = null;
		try {			
			//2 là user mặc định sau khi đăng ký có role là user
			//phải là cart gần đây nhất được tạo
			//để khi thêm các cartItem cartId trỏ tới đúng là cart vừa tạo nếu 1 user nhập trùng sđt và địa chỉ 
			String sql = "Select cartId From Cart Where userId = ? And phoneNumber = ? And address = ? Order By cartId Desc";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, phoneNumber);
			ps.setString(3, address);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("cartId");
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
	public void changeStatusToValid(int cartId) {
		Connection conn = null;
		String sql = "Update Cart Set status = 1 Where cartId = ?";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, cartId);
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
	public void changeStatusToInValid(int cartId) {
		Connection conn = null;
		String sql = "Update Cart Set status = -1 Where cartId = ?";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, cartId);
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
	public void insertNewCart(CartModel cart) {
		Connection conn = null;
		String sql = "Insert Into Cart(userId,buyDate,status,phoneNumber,address) Values(?,?,0,?,?)";
		try {
			conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setInt(1, cart.getUserId());
			ps.setDate(2, cart.getBuyDate());
			ps.setString(3, cart.getPhoneNumber());
			ps.setString(4, cart.getAddress());
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
	public List<CartModel> findAllWaitingOfUser(int userId) {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where userId = ? And status = 0";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(userId);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		return null;
	}

	@Override
	public List<CartModel> findAllValidOfUser(int userId) {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where userId = ? And status = 1";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(userId);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		return null;
	}

	@Override
	public List<CartModel> findAllInValidOfUser(int userId) {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where userId = ? And status = -1";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(userId);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		return null;
	}

	@Override
	public void changeStatusToCheckedOut(int cartId) {
		Connection conn = null;
		String sql = "Update Cart Set status = 2 Where cartId = ?";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
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
	public List<CartModel> findAllCheckOutedOfUser(int userId) {
		Connection conn = null;
		List<CartModel> carts = new ArrayList<CartModel>(); 
		String sql = "Select * From Cart Where status = 2 And userId = ?";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setPhoneNumber(rs.getString("phoneNumber"));
				cart.setAddress(rs.getNString("address"));
				carts.add(cart);
			}
			return carts;
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
		return null;
	}
	
	
}
