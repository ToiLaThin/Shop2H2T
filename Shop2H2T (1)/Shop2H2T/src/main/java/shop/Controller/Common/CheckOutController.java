package shop.Controller.Common;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CartItemModel;
import shop.Models.ReceiptModel;
import shop.Services.Impl.CartItemServicesImpl;
import shop.Services.Impl.CartServicesImpl;
import shop.Services.Impl.InventoryServicesImpl;
import shop.Services.Impl.ReceiptServicesImpl;

@WebServlet(urlPatterns = {"/common/order/checkout"})
public class CheckOutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ReceiptServicesImpl receiptServicesImpl = new ReceiptServicesImpl();
	CartServicesImpl cartServicesImpl = new CartServicesImpl();
	CartItemServicesImpl cartItemServicesImpl = new CartItemServicesImpl();
	InventoryServicesImpl inventoryServicesImpl = new InventoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		java.util.Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("buyDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date buyDate = new Date(utilDate.getTime());		
		//tìm tất cả cartItem thuộc về cartId
		List<CartItemModel> cartItemsOfCart = cartItemServicesImpl.findAllByCartId(cartId);
		//hàm kiểm tra tất cả CartItem ko  hề có outOfProduct
		boolean isOutOfOneProduct = isOutOfOneProduct(cartItemsOfCart);
		
		
		//cập nhật inventory nếu ko có món hàng nào thiếu số lượng
		if(!isOutOfOneProduct) {
			//duyệt qua từng -> lấy productId, quantity -> tính ra newAmount rồi gọi updateInventory có product đó
			for(CartItemModel cartItem : cartItemsOfCart) {
				int productId = cartItem.getProductId();
				int quantity = cartItem.getQuantity();
				int productAmountInInventory = inventoryServicesImpl.findAmount(productId);
				int newProductAmountInInventory = productAmountInInventory - quantity;
				//đã kiểm tra
				inventoryServicesImpl.updateInventory(productId,newProductAmountInInventory);		
				System.out.println(inventoryServicesImpl.findAmount(productId));				
				ReceiptModel receiptToInsert = new ReceiptModel();
				receiptToInsert.setReleaseDate(buyDate);
				receiptToInsert.setCartId(cartId);
				
				receiptServicesImpl.insertReceipt(receiptToInsert);
				cartServicesImpl.changeStatusToCheckedOut(cartId);				
			}
			
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			RequestDispatcher rd = req.getRequestDispatcher("/common/receipt/list");
			rd.forward(req, resp);		
		}
		else {
			//ko thêm id 
			//ko thêm hóa đơn
			req.setAttribute("isOutOfOneProduct", true);
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			RequestDispatcher rd = req.getRequestDispatcher("/common/receipt/list");
			rd.forward(req, resp);
		}
	}
	
	//kiểm tra trước xem có sản phẩm nào thuộc đơn hàng bị lỗi ko
	private boolean isOutOfOneProduct(List<CartItemModel> cartItemsOfCart)
	{
		boolean isOutOfOneProduct = false;
		for(CartItemModel cartItem : cartItemsOfCart) {
			int productId = cartItem.getProductId();
			int quantity = cartItem.getQuantity();
			int productAmountInInventory = inventoryServicesImpl.findAmount(productId);
			
			if(productAmountInInventory < quantity)
			{
				isOutOfOneProduct = true;
				break;
			}
		}
		return isOutOfOneProduct;
	}
	
	

}
