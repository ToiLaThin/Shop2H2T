package shop.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CategoryModel;
import shop.Services.Impl.CategoryServicesImpl;

@WebServlet(urlPatterns = {"/admin/category/list"})
public class CategoryListController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<CategoryModel> categories = categoryServicesImpl.findAll();
		req.setAttribute("categories", categories);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category-list.jsp");
		rd.forward(req, resp);
	}
	
	

}
