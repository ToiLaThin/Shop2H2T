package shop.Controller.Seller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Models.CategoryModel;
import shop.Models.ProductModel;
import shop.Services.Impl.CategoryServicesImpl;
import shop.Services.Impl.InventoryServicesImpl;
import shop.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/seller/product/update"})
public class ProductUpdateController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ProductServicesImpl productService = new ProductServicesImpl();	
	InventoryServicesImpl inventoryService = new InventoryServicesImpl();
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		try {
			ProductModel product = new ProductModel();
			int productId = Integer.parseInt(req.getParameter("productId"));
			product = productService.find(productId);
			//hay productQuantityInInventory
			
			List<CategoryModel> categories = categoryServicesImpl.findAll();
			int productStock = inventoryService.findAmount(productId);
			req.setAttribute("product", product);
			req.setAttribute("productStock", productStock);
			req.setAttribute("categories", categories);
			RequestDispatcher rd =req.getRequestDispatcher("/views/seller/product-update.jsp");
			rd.forward(req, resp);			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		try {
			//edit product
			ProductModel product = new ProductModel();
			int productId = Integer.parseInt(req.getParameter("productId"));
			product.setProductId(productId);
			product.setProductName(req.getParameter("productName"));
			product.setDescription(req.getParameter("productDescription"));
			product.setPrice(Float.parseFloat(req.getParameter("productPrice")));
			product.setImages(req.getParameter("productImage"));
			product.setStatus(Integer.parseInt(req.getParameter("productStatus")));
			product.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
			
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date date = parser.parse(req.getParameter("productModifiedDate"));
	        Date sqlDate = new Date(date.getTime());
			product.setModifiedDate(sqlDate);
			productService.editProduct(product);

			//edit quantity in inventory
			int newProductStock = Integer.parseInt(req.getParameter("productStock"));
			inventoryService.updateInventory(productId, newProductStock);
			
			resp.sendRedirect(req.getContextPath() + "/seller/home");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
