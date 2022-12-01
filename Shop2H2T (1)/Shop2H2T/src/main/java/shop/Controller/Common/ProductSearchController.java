package shop.Controller.Common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CategoryModel;
import shop.Models.ProductModel;
import shop.Services.Impl.CategoryServicesImpl;
import shop.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/common/product/search"})
public class ProductSearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ProductServicesImpl productService = new ProductServicesImpl();
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String searchPhrase = (String) req.getParameter("searchPhrase");
		List<ProductModel> productSearched = productService.findBySearch(searchPhrase);
		boolean accountDisabled = false;
		boolean orderSuccess = false;
		if(req.getAttribute("accountDisabled") != null) {
			accountDisabled = (boolean) req.getAttribute("accountDisabled");
		}
		if(req.getAttribute("orderSuccess") != null) {
			orderSuccess = (boolean) req.getAttribute("orderSuccess");
		}
		req.setAttribute("productList", productSearched);
		req.setAttribute("accountDisabled", accountDisabled);
		req.setAttribute("orderSuccess", orderSuccess);
		List<CategoryModel> categories = categoryServicesImpl.findAll();
		req.setAttribute("categories", categories); 
		RequestDispatcher rd = req.getRequestDispatcher("/views/common/home.jsp");
		rd.forward(req, resp);
	}

	
}
