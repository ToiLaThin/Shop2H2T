package shop.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Services.IAccountServices;
import shop.Services.Impl.AccountServicesImpl;



@WebServlet(urlPatterns = {"/admin/user/changestatus1","/admin/user/changestatus0"})
public class ChangeStatusController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IAccountServices IAS =new AccountServicesImpl();
		int id=Integer.parseInt(req.getParameter("userid"));
		
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/user/changestatus0")) {
			IAS.changeStatus(id, 0);
		}
		if (url.contains("/admin/user/changestatus1")) {
			IAS.changeStatus(id, 1);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/admin/account/status?accid="+id);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
