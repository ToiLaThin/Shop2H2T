<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ page import="shop.Models.CartItemModel" %>
<%@ page import="shop.Services.Impl.InventoryServicesImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE CART</h1>
     </div>
</section>

<c:if test="${cart == null }">
	<h1>Bạn chưa mua gì cả </h1>
</c:if>
<c:if test="${cart.size() == 0 }">
	<h1>Bạn chưa mua gì cả </h1>
</c:if>
<c:if test="${cart != null }">	
	<div class="container mb-4">
	    <div class="row">
	        <div class="col-12">
	            <div class="table-responsive">             
	                <table class="table table-striped">
	                    <thead>
	                        <tr>
	                            <th scope="col"> </th>
	                            <th scope="col">Product</th>
	                            <th scope="col">Available</th>
	                            <th scope="col" class="text-center">Quantity</th>
	                            <th scope="col" class="text-right">Price</th>
	                            <th> </th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<!-- tag declare chỉ chạy 1 lần -->
	                    	<%! float totalPrice; %>
	                    	<%               
	                    		totalPrice = 0;
	                    		List<CartItemModel> cart = (List<CartItemModel>)session.getAttribute("cart");
	                    		for(CartItemModel cartItem: cart) {                    			
	                    			int quantity = cartItem.getQuantity();
	                    			float productPricePerUnit = cartItem.getProduct().getPrice();
	                    			totalPrice += quantity * productPricePerUnit;
	                    			out.println("<span> " +quantity + "c</span>");
	                    			out.println("<span> " +productPricePerUnit + "c</span><br>");
	                    		}
	                    	%>
	                    	<c:forEach items="${cart }" var="cartItem" varStatus="STT">
		                        <tr>
		                            <td><img src="${cartItem.product.images }" width="50" height="50"/> </td>
		                            <td>${cartItem.product.productName }</td>
		                            <td>So luong hang trong kho:</td>
		                            <td><input class="form-control" type="text" value="${cartItem.quantity}" /></td>
		                            <td class="text-right">${cartItem.product.price} €</td>
		                            <td class="text-right"><a class="btn btn-sm btn-danger" href="<%=request.getContextPath() %>/common/cart?action=remove&productId=${cartItem.product.productId}"><i class="fa fa-trash"></i> </a> </td>
		                        </tr>      	                     
	                        </c:forEach>                  
	                        <tr>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td>Sub-Total</td>
	                            <td class="text-right"><%=totalPrice %></td>
	                        </tr>
	                        <tr>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td>Shipping</td>
	                            <td class="text-right">6,90 €</td>
	                        </tr>
	                        <tr>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td><strong>Total</strong></td>
	                            <td class="text-right"><strong><%=totalPrice+6.90 %> €</strong></td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	        </div>
	        <div class="col mb-2">
	            <div class="row">
	                <div class="col-sm-12  col-md-6">
	                    <a class="btn btn-block btn-light" href="<%=request.getContextPath() %>/common/home">Continue Shopping</a>
	                </div>
	                <div class="col-sm-12 col-md-6 text-right">
	               	<c:if test="${isLogin != null }">
		               	<c:set var = "isLogin" value = "false"/>
		               	<c:set var = "username" value = '${session.getAttribute("username") }'/>                    
	               	</c:if>
	               	<c:if test="${username != null }">
	                    <c:set var = "isLogin" value = "true"/>
	               	</c:if>
	               	<c:if test="${username == null }">
	                    <c:set var = "isLogin" value = "false"/>
	               	</c:if>
	               	<c:if test="${isLogin == true }">
	                    <a class='btn btn-block btn-success btn-lg' href='<%=request.getContextPath() %>/common/order'>Order</a>
	               	</c:if>
	               	<c:if test="${isLogin == false }">
	                    <a class='btn btn-block btn-success btn-lg' href='<%=request.getContextPath() %>/views/common/login.jsp'>Order</a>
	               	</c:if>
	                </div>                
	            </div>
	        </div>
	    </div>    
	</div>
</c:if>

<script type="text/javascript">
	window.onload = function() {
		let outOfProduct = ${outOfProduct};
		console.log(outOfProduct);
		console.log(typeof(outOfProduct));
		
		if(outOfProduct === true)
			{
				alert("Không còn hàng trong kho");
				let root = "${pageContext.request.contextPath}"				
				window.location.href = root + "/common/home";
			}
	}
</script>
