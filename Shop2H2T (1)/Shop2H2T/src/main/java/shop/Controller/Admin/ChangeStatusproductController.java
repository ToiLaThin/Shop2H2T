package shop.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.ProductModel;
import shop.Services.IProductServices;
import shop.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/admin/product/changestatus"})
public class ChangeStatusproductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1544634944957746011L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idPro= Integer.parseInt(req.getParameter("productId"));
		IProductServices PS=new ProductServicesImpl();
		ProductModel pro=PS.find(idPro);
		if (pro.getStatus()==1) {
			pro.setStatus(0);
			System.out.println(pro.getCategoryId());
		}
		else {
			pro.setStatus(1);
			System.out.println(pro.getCategoryId());
		}
		PS.editProduct(pro);
		req.setAttribute("product", pro); 
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/product.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
