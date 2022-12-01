package shop.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Connection.DbConnection;
import shop.Models.AccountModel;
import shop.Models.CartModel;
import shop.Models.ProductModel;
import shop.Services.IAccountServices;
import shop.Services.IProductServices;
import shop.Services.Impl.AccountServicesImpl;
import shop.Services.Impl.ProductServicesImpl;
@WebServlet(urlPatterns = {"/admin/UAPManage"})
public class UAPManage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IAccountServices ASI = new AccountServicesImpl();
		List<AccountModel> Accs = ASI.findAll();
		IProductServices Pros= new ProductServicesImpl();
		List<ProductModel> Products= Pros.findAll();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("accs", Accs);
		req.setAttribute("pros", Products);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/UAPManage.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
	public static void main(String[] args) throws Exception {
		IAccountServices ASI = new AccountServicesImpl();
		List<AccountModel> Accs = ASI.findAll();
		System.out.print(Accs.size());
	}
}
