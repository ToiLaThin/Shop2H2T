package shop.Controller.Seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Services.Impl.InventoryServicesImpl;
import shop.Services.Impl.ProductServicesImpl;


@WebServlet(urlPatterns= {"/seller/product/delete"})
public class ProductDeleteController extends HttpServlet{
	ProductServicesImpl productService = new ProductServicesImpl();
	InventoryServicesImpl inventoryService = new InventoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		req.setAttribute("productId", productId);
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/product-delete.jsp");
		rd.forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			HttpSession session = req.getSession();
			int storeId = (int)session.getAttribute("storeId");
			inventoryService.deleteInventory(productId, storeId);
			productService.deleteProduct(productId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/common/home");
		
	}

	private static final long serialVersionUID = 1L;
	
	
}
