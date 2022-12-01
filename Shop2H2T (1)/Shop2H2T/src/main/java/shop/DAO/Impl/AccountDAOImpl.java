package shop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.Connection.DbConnection;
import shop.DAO.IAccountDAO;
import shop.Models.AccountModel;
import shop.Models.ProductModel;

public class AccountDAOImpl extends DbConnection implements IAccountDAO{

	@Override
	public boolean authenticateAccount(String username, String password) {
		boolean isValid = false;
		Connection conn = null;
		try {
			String sql = "Select * From Account Where username = ? And password = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				isValid = true;
			else
				isValid = false;						
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
		
		return isValid;
	}

	@Override
	public String findRoleAccount(String username, String password) {
		Connection conn = null;
		try {
			String sql = "Select ur.roleName\r\n"
					+ "From Account u Inner Join Admin ur\r\n"
					+ "On u.roleId = ur.roleId\r\n"
					+ "Where u.username = ? And u.password = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getNString("roleName");
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
		return "";		
	}

	@Override
	public void registerAccount(String username, String password) {
		Connection conn = null;
		try {
			//2 là user mặc định sau khi đăng ký có role là user và status là 0(active)
			String sql = "Insert Into Account(username,password,roleId,status) Values (?,?,2,0)";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
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
	public void becomeSeller(int sellerId,String username) {
		Connection conn = null;
		try {
			//2 là user mặc định sau khi đăng ký có role là user
			String sql = "Update Account Set sellerid = ?,roleId = 3 Where username = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerId);
			ps.setString(2, username);
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
	public int findSellerId(String username) {
		Connection conn = null;
		try {
			String sql = "Select sellerid From Account Where username = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("sellerid");
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
	public int findAccountId(String username) {
		Connection conn = null;
		try {
			//2 là user mặc định sau khi đăng ký có role là user
			String sql = "Select userId From Account Where username = ?";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("userId");
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
		return -1;
	}

	@Override
	public List<AccountModel> findAll() {
		List<AccountModel> accs = new ArrayList<AccountModel>();
		String sql = "Select * From Account";
		Connection conn = null;
		
		
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				AccountModel acc = new AccountModel();
				
				acc.setUserId(rs.getInt("userId"));
				acc.setUsername(rs.getString("username"));
				acc.setEmail(rs.getString("email"));
				acc.setFullname(rs.getString("fullname"));
				acc.setPassword(rs.getString("password"));
				acc.setImages(rs.getString("images"));
				acc.setPhone(rs.getString("phone"));
				acc.setStatus(rs.getInt("status"));
				acc.setCode(rs.getString("code"));
				acc.setRoleId(rs.getInt("roleId"));
				acc.setSellerId(rs.getInt("sellerid"));
				acc.setStatus(rs.getInt("status"));
				accs.add(acc);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally  {           
		        if ( conn != null )
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}  
		}
		    
		return accs;
	}

	@Override
	public AccountModel findById(int id) {
		AccountModel acc=new AccountModel();
		String sql ="Select * from Account where userId=?";
		Connection conn = null;
		
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				acc.setUserId(rs.getInt("userId"));
				acc.setUsername(rs.getString("username"));
				acc.setEmail(rs.getString("email"));
				acc.setFullname(rs.getString("fullname"));
				acc.setPassword(rs.getString("password"));
				acc.setImages(rs.getString("images"));
				acc.setPhone(rs.getString("phone"));
				acc.setStatus(rs.getInt("status"));
				acc.setCode(rs.getString("code"));
				acc.setRoleId(rs.getInt("roleId"));
				acc.setSellerId(rs.getInt("sellerid"));
				acc.setStatus(rs.getInt("status"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally  {           
	        if ( conn != null )
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return acc;
	}

	@Override
	public void changeStatus(int id,int status) {
		
		String sql="Update Account Set status = ? Where userId = ?";
		Connection conn = null;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
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
	public void registerAccount(AccountModel account) {
		Connection conn = null;
		try {
			String sql = "Insert Into Account(username,password,roleId,status,email,fullname,images,phone) Values (?,?,2,0,?,?,?,?)";
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getEmail());
			ps.setString(4, account.getFullname());
			ps.setString(5, account.getImages());
			ps.setString(6, account.getPhone());
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
	
	
}
