package shop.Controller.Common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Models.AccountModel;
import shop.Services.Impl.AccountServicesImpl;
import shop.Services.Impl.SellerServicesImpl;
import shop.Services.Impl.StoreServicesImpl;

@WebServlet(urlPatterns = {"/common/login"})
public class AccountLoginController extends HttpServlet{

	AccountServicesImpl accountService = new AccountServicesImpl();
	SellerServicesImpl sellerService = new SellerServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean loginSuccessful = accountService.authenticateAccount(username, password);
		if(loginSuccessful) {
			int accountId = accountService.findAccountId(username);
			AccountModel account = accountService.findById(accountId);
			int accountStatus = account.getStatus();
			if(accountStatus == 0)
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", username);				
				String userRole = (String)accountService.findRoleAccount(username, password);
				session.setAttribute("userRole", userRole);
				if(userRole.equalsIgnoreCase("seller"))
				{
					//nếu user role là seller session đưa sellerId vào
					int sellerId = accountService.findSellerId(username);
					session.setAttribute("sellerId", sellerId);
					session.setAttribute("storeId", sellerService.findStoreId(sellerId));
				}
				req.setAttribute("accountDisabled", false);
				RequestDispatcher rd = req.getRequestDispatcher("/common/home");
				rd.forward(req, resp);
			}
			else if(accountStatus == 1)
			{
				req.setAttribute("accountDisabled", true);
				RequestDispatcher rd = req.getRequestDispatcher("/common/home");
				rd.forward(req, resp);
			}		
		}
		else {
			req.setAttribute("loginFailed", true);
			//vì ko thực hiện register
			req.setAttribute("registerSuccess", false);
			RequestDispatcher rd = req.getRequestDispatcher("/views/common/login.jsp");
			rd.forward(req, resp);
		}	
	}

	private static final long serialVersionUID = 1L;

}
