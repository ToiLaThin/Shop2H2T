package shop.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CartModel;
import shop.Services.Impl.CartServicesImpl;


@WebServlet(urlPatterns = {"/admin/cart/list"})
public class CartListController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CartServicesImpl cartService = new CartServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CartModel> waitingCarts = cartService.findAllWaiting();
		List<CartModel> validCarts = cartService.findAllValid();
		List<CartModel> inValidCarts = cartService.findAllInValid();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("inValidCarts", inValidCarts);
		req.setAttribute("validCarts", validCarts);
		req.setAttribute("waitingCarts", waitingCarts);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/cart-list.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
