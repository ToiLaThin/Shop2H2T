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

@WebServlet(urlPatterns = {"/admin/category/insert"})
public class CategoryInsertController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category-insert.jsp");
		rd.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		category.setCategoryName(req.getParameter("categoryName"));
		category.setImages(req.getParameter("categoryImage"));
		
		categoryServicesImpl.insertCategory(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
	
	

}
