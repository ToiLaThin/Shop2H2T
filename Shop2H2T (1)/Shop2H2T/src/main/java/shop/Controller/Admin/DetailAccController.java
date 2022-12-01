package shop.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.AccountModel;
import shop.Services.IAccountServices;
import shop.Services.Impl.AccountServicesImpl;



@WebServlet(urlPatterns = {"/admin/account/status"})
public class DetailAccController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IAccountServices IAS=new AccountServicesImpl();
		int accid= Integer.parseInt(req.getParameter("accid"));
		AccountModel acc=IAS.findById(accid);
		req.setAttribute("acc", acc);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/userinfor.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
