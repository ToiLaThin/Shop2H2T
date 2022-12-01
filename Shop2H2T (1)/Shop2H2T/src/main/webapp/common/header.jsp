<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ page import="shop.Models.CartItemModel" %>
<%@ page import="java.util.List" %>


<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.html">Simple Ecommerce</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<%=request.getContextPath() %>/common/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <c:if test="${ userRole.equalsIgnoreCase('admin')}">
	                <li class="nav-item">
	                    <a class="nav-link" href="<%=request.getContextPath() %>/admin/category/list">Categories</a>
	                </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath() %>/user/product/list">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath() %>/user/cart">Cart</a>
                </li>
            </ul>
            
            <c:url value="/common/product/search" var="productSearchControllerUrl"></c:url>
			<form role="form" action=${productSearchControllerUrl } method="post" class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" placeholder="Search..." name="searchPhrase" required>
					<div class="input-group-append">
						<button type="submit" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>
			
			<ul class="navbar-nav m-auto align-items-center">
                <%!int cartSize;%>
                <%
                List<CartItemModel> cart = (List<CartItemModel>) session.getAttribute("cart");
                if (cart != null) {
                	cartSize = cart.size();
                } else
                	cartSize = 0;
                String rootPath = request.getContextPath();
                String registerPageUrl = rootPath + "/views/common/register.jsp";
                String emptyRole = "";
                String username = (String) session.getAttribute("username");
                String userRole = (String) session.getAttribute("userRole");
                String logoutPageUrl = rootPath + "/common/logout";
                %>
             	<li class="nav-item active">
	                <a class="btn btn-success btn-sm ml-3" href="<%=request.getContextPath() %>/common/cart">
	                    <i class="fa fa-shopping-cart"></i> Cart
	                    <span class="badge badge-light"><%=cartSize%></span>
	                </a>
                </li>
                <!-- có role chắc chắn có username -->
                <c:if test="${ userRole != emptyRole && username != null}">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="<%=request.getContextPath()%>/user/cart"> 
						<i class="fa fa-user"></i> ${userRole } ${username}
					</a>
					<ul class="dropdown-menu"
						aria-labelledby="navbarScrollingDropdown">
						<c:if test="${ userRole.equalsIgnoreCase('admin')}">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/admin/cart/list"> Order
								management </a>
						</c:if>
						<c:if test="${ userRole.equalsIgnoreCase('admin')}">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/admin/UAPManage"> User
								and Product Management </a>
						</c:if>
						<c:if test="${ userRole.equalsIgnoreCase('user')}">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/views/user/registerSeller.jsp">
								Open Shop </a>
						</c:if>
						<c:if test="${ userRole.equalsIgnoreCase('seller')}">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/seller/home"> My Shop </a>
						</c:if>
						<a class="dropdown-item" href="<%=request.getContextPath()%>/common/receipt/list">Orders and receipts </a>
						<li><hr class='dropdown-divider'></li>
						<%    
	                		out.print("<a href='"+ logoutPageUrl + "' class='dropdown-item'>Logout</a>");
		                	out.print("<a href='"+ registerPageUrl + "' class='dropdown-item'>Register</a>");
		                %>
					</ul>
				</li>
				</c:if>
				
				
                <c:if test="${ userRole == emptyRole && username == null}">
                <li class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle" id="secondNavBarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="<%=request.getContextPath()%>/user/cart"> 
						<i class="fa fa-gear fa-lg mr-1 ml-2"></i>	
					</a>
					<ul class="dropdown-menu" aria-labelledby="secondNavBarScrollingDropdown">
	                	 <%    
	                		String loginPageUrl = rootPath + "/views/common/login.jsp";
	                		out.print("<a href='"+ loginPageUrl + "' class='dropdown-item'>Login</a>");
		                	out.print("<a href='"+ registerPageUrl + "' class='dropdown-item'>Register</a>");
		                 %>
	               </ul> 
                </li>  
                </c:if> 
            </ul>            
        </div>
    </div>
</nav>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
        <p class="lead text-muted mb-0">Simple theme for e-commerce buid with Bootstrap 4.0.0. Pages available : home, category, product, cart & contact</p>
    </div>
</section>

