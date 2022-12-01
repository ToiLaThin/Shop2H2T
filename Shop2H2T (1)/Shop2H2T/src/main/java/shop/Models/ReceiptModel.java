package shop.Models;

import java.sql.Date;

public class ReceiptModel {
	int receiptId;
	Date releaseDate;
	int cartId;
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	@Override
	public String toString() {
		return "ReceiptModel [receiptId=" + receiptId + ", releaseDate=" + releaseDate + ", cartId=" + cartId + "]";
	}
	
	
}
