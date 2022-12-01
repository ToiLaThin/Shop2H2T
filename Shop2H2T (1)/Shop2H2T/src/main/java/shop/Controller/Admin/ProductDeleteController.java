package shop.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Services.Impl.ProductServicesImpl;


@WebServlet(urlPatterns= {"/admin/product/delete"})
public class ProductDeleteController extends HttpServlet{
	ProductServicesImpl productService = new ProductServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		req.setAttribute("productId", productId);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product-delete.jsp");
		rd.forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			productService.deleteProduct(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/user/home");
		
	}

	private static final long serialVersionUID = 1L;
	
	
}
