package shop.Controller.Seller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Models.CategoryModel;
import shop.Models.ProductModel;
import shop.Services.Impl.CategoryServicesImpl;
import shop.Services.Impl.InventoryServicesImpl;
import shop.Services.Impl.ProductServicesImpl;


@WebServlet(urlPatterns= {"/seller/product/insert"})
public class ProductInsertController extends HttpServlet{
	ProductServicesImpl productService = new ProductServicesImpl();	
	InventoryServicesImpl inventoryService = new InventoryServicesImpl();
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<CategoryModel> categories = categoryServicesImpl.findAll();
		req.setAttribute("categories", categories);
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/product-insert.jsp");
		rd.forward(req, resp);
		
	}

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
			product.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
			productService.insertProduct(product);	
			
			int productInsertedId = productService.findProductId(product);
			int stock = Integer.parseInt((String)req.getParameter("productStock"));
			int storeId = (int) session.getAttribute("storeId");
			
			inventoryService.insertInventory(productInsertedId, storeId, stock);
			isValidated = true;
		} catch (Exception e) {
			e.printStackTrace();
			isValidated = false;
		}	
		
		if(isValidated) {
			resp.sendRedirect(req.getContextPath() + "/seller/home");			
		}
		else {
			List<CategoryModel> categories = categoryServicesImpl.findAll();
			req.setAttribute("categories", categories);
			RequestDispatcher rd = req.getRequestDispatcher("/views/seller/product-insert.jsp");
			rd.forward(req, resp);						
		}
		
	}

	private static final long serialVersionUID = 1L;
	
	
}
