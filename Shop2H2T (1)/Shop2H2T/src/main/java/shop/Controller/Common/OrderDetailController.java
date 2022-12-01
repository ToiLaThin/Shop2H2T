package shop.Controller.Common;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CartItemModel;
import shop.Models.ProductModel;
import shop.Models.ReceiptModel;
import shop.Services.Impl.CartItemServicesImpl;
import shop.Services.Impl.ProductServicesImpl;
import shop.Services.Impl.ReceiptServicesImpl;

@WebServlet(urlPatterns = {"/common/receipt/detail","/common/order/detail"})
public class OrderDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CartItemServicesImpl cartItemServicesImpl = new CartItemServicesImpl();
	ProductServicesImpl productServicesImpl = new ProductServicesImpl();
	ReceiptServicesImpl receiptServicesImpl = new ReceiptServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		int receiptId = Integer.parseInt(req.getParameter("receiptId"));
		ReceiptModel receipt = receiptServicesImpl.find(receiptId);
		Date releaseDate = receipt.getReleaseDate();
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		List<CartItemModel> cart = cartItemServicesImpl.findAllByCartId(cartId);
		for(CartItemModel cartItem : cart) {
			int productId = cartItem.getProductId();
			ProductModel product = productServicesImpl.find(productId);
			cartItem.setProduct(product);
		}
		req.setAttribute("cart", cart);
		req.setAttribute("releaseDate", releaseDate);
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/receipt-detail.jsp");
		rd.forward(req, resp);
	}
	

}
