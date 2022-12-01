package shop.Controller.Admin;

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

import shop.Models.ProductModel;
import shop.Services.Impl.ProductServicesImpl;


@WebServlet(urlPatterns= {"/admin/product/insert"})
public class ProductInsertController extends HttpServlet{
	ProductServicesImpl productService = new ProductServicesImpl();	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel product = new ProductModel();
		boolean isValidated = false;
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			
			product.setProductName(req.getParameter("productName"));
			product.setDescription(req.getParameter("productDescription"));
			product.setPrice(Float.parseFloat(req.getParameter("productPrice")));			
			//product.setStock(Integer.parseInt(req.getParameter("productStock")));
			product.setImages(req.getParameter("productImage"));
			
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date date = parser.parse(req.getParameter("productCreateDate"));
	        Date sqlDate = new Date(date.getTime());
	        HttpSession session = req.getSession();
	        int currSellerId = (int)session.getAttribute("sellerId");
	        
			product.setModifiedDate(sqlDate);
			product.setSellerId(currSellerId);
			productService.insertProduct(product);		
			
			int productInsertedId = productService.findProductId(product);
			
			isValidated = true;
		} catch (Exception e) {
			e.printStackTrace();
			isValidated = false;
		}	
		
		if(isValidated) {
			resp.sendRedirect(req.getContextPath() + "/seller/home");			
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/views/seller/product-insert.jsp");						
		}
		
	}

	private static final long serialVersionUID = 1L;
	
	
}
