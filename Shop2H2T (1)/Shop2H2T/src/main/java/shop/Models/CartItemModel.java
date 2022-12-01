package shop.Models;

public class CartItemModel {
	
	int cartItemId;
	ProductModel product;
	int quantity;
	float unitPrice;
	int productId;
	int cartId;
	
	public CartItemModel(ProductModel product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = product.getPrice();
		this.productId = product.getProductId();
	}
	
	
	public CartItemModel() {
		super();
	}


	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	@Override
	public String toString() {
		return "CartItemModel [cartItemId=" + cartItemId + ", product=" + product + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", productId=" + productId + ", cartId=" + cartId + "]";
	}

	
	
	
	
	
	
}
