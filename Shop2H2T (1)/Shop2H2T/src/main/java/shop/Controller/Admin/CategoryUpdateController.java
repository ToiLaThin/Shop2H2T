package shop.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CategoryModel;
import shop.Services.Impl.CategoryServicesImpl;

@WebServlet(urlPatterns = {"/admin/category/update"})
public class CategoryUpdateController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		System.out.println("Come here");
		CategoryModel category = categoryServicesImpl.find(categoryId);
		req.setAttribute("category", category);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category-update.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		category.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
		category.setCategoryName(req.getParameter("categoryName"));
		category.setImages(req.getParameter("categoryImage"));
		
		categoryServicesImpl.editCategory(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
	
	

}
