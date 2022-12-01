<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="container mt-3 mb-5">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> All Product for category: ${categoryName} 
                </div>
                <div class="card-body">
                    <div class="row">
                    	<c:forEach items="${productsByCategory }" var="product" varStatus="Stt">	  
	                    	<c:if test="${product.status == 0}">                            
		                        <div class="col-lg-4 col-md-6 col-sm-12 my-2">
		                            <div class="card">
		                                <img class="card-img-top" src="${product.images }" alt="Card image cap" width="600" height="280">
		                                <div class="card-body">
		                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/common/product/detail?productId=${product.productId }" title="View Product">${product.productName }</a></h4>
		                                    <c:if test="${product.description.length() < 150}">
		                                    <p class="card-text">${product.description}</p>
		                                    </c:if>
		                                    
		                                    <c:if test="${product.description.length() >= 150}">
		                                    <p class="card-text">${product.description.substring(0,149)}...</p>
		                                    </c:if>
		                                    <div class="row">
		                                        <div class="col">
		                                            <p class="btn btn-danger btn-block">${product.price} $</p>
		                                        </div>
		                                        <div class="col">
		                                            <a href="<%=request.getContextPath() %>/common/cart?productId=${product.productId }&action=addToCart" class="btn btn-success btn-block">Add to cart</a>
		                                        </div>
		                                    </div>
		                                    
		                                    <div class="row">
		                                        <div class="col">		                                        
								               	<c:if test="${username != null }">
								                    <c:set var = "isLogin" value = "true"/>
								               	</c:if>
								               	<c:if test="${username == null }">
								                    <c:set var = "isLogin" value = "false"/>
								               	</c:if>
								               	<c:if test="${isLogin == true }">
								                    <a href="<%=request.getContextPath() %>/common/buyNow?productId=${product.productId }" class="btn btn-primary btn-block">Buy now</a>
								               	</c:if>
								               	<c:if test="${isLogin == false }">
								                    <a href="<%=request.getContextPath() %>/views/common/login.jsp" class="btn btn-primary btn-block">Buy now</a>
								               	</c:if>
		                                            
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
	                        </c:if>
	                        
	                        <c:if test="${product.status == 1}">                   
		                        <div class="col-lg-4 col-md-6 col-sm-12 my-2">
		                            <div class="card bg-secondary">
		                                <img class="card-img-top" src="${product.images }" alt="Card image cap" width="600" height="280">
		                                <div class="card-body">
		                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/common/product/detail?productId=${product.productId }" title="View Product" class="text-dark">${product.productName }</a></h4>
		                                    <p class="card-text">Locked by admin</p>
		                                    <div class="row">
		                                        <div class="col">
		                                            <p class="btn btn-danger btn-block">${product.price} $</p>
		                                        </div>
		                                        <div class="col">
		                                            <a href="" class="btn btn-warning btn-block">Add to cart</a>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
	                        </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
	
	
