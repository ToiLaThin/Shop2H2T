package shop.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Services.Impl.CartServicesImpl;


@WebServlet(urlPatterns = {"/admin/cart/change/valid" , "/admin/cart/change/inValid"})
public class CartChangeController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CartServicesImpl cartService = new CartServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		//lay url dc gui toi
		if (url.contains("cart/change/valid")) {
			cartChangeValid(req,resp);		
		}
		if (url.contains("cart/change/inValid")) {
			cartChangeInValid(req, resp);
		}
	}

	private void cartChangeInValid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		cartService.changeStatusToInValid(cartId);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/cart/list");
		rd.forward(req, resp);
	}

	private void cartChangeValid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		cartService.changeStatusToValid(cartId);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/cart/list");
		rd.forward(req, resp);
	}
	

}
