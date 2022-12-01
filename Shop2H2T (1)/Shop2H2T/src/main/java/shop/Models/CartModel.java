package shop.Models;
import java.sql.Date;

public class CartModel {
	int cartId;
	int userId;
	Date buyDate;
	int status;
	String phoneNumber;
	String address;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "CartModel [cartId=" + cartId + ", userId=" + userId + ", buyDate=" + buyDate + ", status=" + status
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
}
