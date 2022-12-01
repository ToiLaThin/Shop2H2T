package shop.Controller.Common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.AccountModel;
import shop.Services.Impl.AccountServicesImpl;

@WebServlet(urlPatterns = {"/common/register"})
public class AccountRegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AccountServicesImpl accountService = new AccountServicesImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String confirmedPassword = req.getParameter("confirmedPassword");
		if(password.equals(confirmedPassword))
		{
			AccountModel account=new AccountModel();
			account.setUsername(username);
			account.setPassword(password);
			account.setFullname(fullname);
			account.setEmail(email);
			account.setPhone(phone);
			accountService.registerAccount(account);
			req.setAttribute("registerSuccess", true);
			req.setAttribute("loginFailed", false);
			req.setAttribute("registerSellerSuccess", false);
			RequestDispatcher rd = req.getRequestDispatcher("/views/common/login.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("passwordsMismatch", true);
			RequestDispatcher rd = req.getRequestDispatcher("/views/common/register.jsp");
			rd.forward(req, resp);
		}
	}
	

}
