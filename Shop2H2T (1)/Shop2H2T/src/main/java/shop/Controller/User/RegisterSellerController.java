package shop.Controller.User;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Services.Impl.AccountServicesImpl;
import shop.Services.Impl.SellerServicesImpl;
import shop.Services.Impl.StoreServicesImpl;


@WebServlet(urlPatterns= {"/user/registerSeller"})
public class RegisterSellerController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	SellerServicesImpl sellerServicesImpl = new SellerServicesImpl();
	AccountServicesImpl accountServicesImpl = new AccountServicesImpl();
	StoreServicesImpl storeServicesImpl = new StoreServicesImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//tạo 1 seller với thông tin đã đkí trên form có tên doanh nghiệp có 
		resp.setContentType("text/html;charset=UTF-8");		
		String sellerName = req.getParameter("tenDoanhNghiep");
		String storeName = req.getParameter("tenCuaHang");
		String maSoDoanhNghiep = req.getParameter("maSoDoanhNghiep");
		String maSoNoiBo = req.getParameter("maSoNoiBo");
		if(maSoDoanhNghiep.length() == 10 && maSoNoiBo.length() == 10)
		{			
			//SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date date = new java.util.Date();
	        Date sqlDate = new Date(date.getTime());
	        storeServicesImpl.insertStore(storeName, sqlDate);
	        int storeInsertedId = storeServicesImpl.findStoreId(storeName);
	        
			sellerServicesImpl.insertSeller(sellerName,storeInsertedId);
			//gắn sellerId đó với user hiện  tại(cập nhật bảng user)
			//đổi role user này thành seller
			int sellerId = sellerServicesImpl.findSellerId(sellerName);
			HttpSession session = req.getSession();
			String username = (String) session.getAttribute("username");	
			accountServicesImpl.becomeSeller(sellerId, username);
			
			req.setAttribute("registerSuccess", false);
			req.setAttribute("loginFailed", false);
			req.setAttribute("registerSellerSuccess", true);
			RequestDispatcher rd = req.getRequestDispatcher("/views/common/login.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("registerSellerFailed", true);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/registerSeller.jsp");
			rd.forward(req, resp);
			//dùng resp khi ko có attribute
			//dùng RequestDispatcher thì đích phải có hỗ trợ phương thức post nếu hiện tại là post
			//resp.sendRedirect(req.getContextPath() + "/views/user/registerSeller.jsp");
		}
		
	}
	

}
