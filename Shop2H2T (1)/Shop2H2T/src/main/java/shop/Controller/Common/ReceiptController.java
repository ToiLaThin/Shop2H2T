package shop.Controller.Common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Models.CartModel;
import shop.Models.ReceiptModel;
import shop.Services.Impl.AccountServicesImpl;
import shop.Services.Impl.CartServicesImpl;
import shop.Services.Impl.ReceiptServicesImpl;

@WebServlet(urlPatterns = {"/common/receipt/list"})
public class ReceiptController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CartServicesImpl cartService = new CartServicesImpl();
	AccountServicesImpl accountService = new AccountServicesImpl();
	ReceiptServicesImpl receiptService = new ReceiptServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		int userId = accountService.findAccountId(username);
		List<CartModel> waitingCartsOfUser = cartService.findAllWaitingOfUser(userId);
		List<CartModel> validCartsOfUser = cartService.findAllValidOfUser(userId);
		List<CartModel> checkOutedCartsOfUser = cartService.findAllCheckOutedOfUser(userId);
		List<ReceiptModel> receiptsOfUser = receiptService.findAllOfCheckOutedCarts(checkOutedCartsOfUser);
		boolean isOutOfOneProduct = false;
		if(req.getAttribute("isOutOfOneProduct") != null) {
			isOutOfOneProduct = (boolean) req.getAttribute("isOutOfOneProduct");
		}
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("waitingCartsOfUser", waitingCartsOfUser);
		req.setAttribute("validCartsOfUser", validCartsOfUser);
		req.setAttribute("receiptsOfUser", receiptsOfUser);
		req.setAttribute("isOutOfOneProduct", isOutOfOneProduct);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/receipt.jsp");
		rd.forward(req, resp);
	}
	
	
}
