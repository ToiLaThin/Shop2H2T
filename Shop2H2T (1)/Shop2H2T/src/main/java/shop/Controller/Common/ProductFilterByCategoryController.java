package shop.Controller.Common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.ProductModel;
import shop.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/common/product/filter"})
public class ProductFilterByCategoryController extends HttpServlet{

	ProductServicesImpl productServicesImpl = new ProductServicesImpl();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		String categoryName = req.getParameter("categoryName");
		List<ProductModel> productsByCategory = productServicesImpl.findByCategory(categoryId);
		req.setAttribute("productsByCategory", productsByCategory);
		req.setAttribute("categoryName", categoryName);
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/product-filterCategory.jsp");
		rd.forward(req, resp);
	}
	
	

}
