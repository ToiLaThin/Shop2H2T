package shop.Controller.Common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Models.CartItemModel;
import shop.Services.Impl.InventoryServicesImpl;
import shop.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/common/buyNow"})
public class BuyNowController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	ProductServicesImpl productServicesImpl = new ProductServicesImpl();
	InventoryServicesImpl inventoryServicesImpl = new InventoryServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int productId = Integer.parseInt(req.getParameter("productId"));
		List<CartItemModel> cart = new ArrayList<CartItemModel>();
		int productAmountInInventory = inventoryServicesImpl.findAmount(productId);
		if(productAmountInInventory > 0) //bao gồm cả khác -1
		{
			cart.add(new CartItemModel(productServicesImpl.find(productId),1));
			req.setAttribute("cart", cart);
			
			HttpSession session = req.getSession();
			//xóa cart cũ trong session 
			session.removeAttribute("cart");
			//cart mới là có duy nhất sp mua ngay số lượng là 1
			session.setAttribute("cart", cart);
		}
		else
			req.setAttribute("outOfProduct", true);
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/order.jsp");
		rd.forward(req, resp);		
	}
	
	

}
