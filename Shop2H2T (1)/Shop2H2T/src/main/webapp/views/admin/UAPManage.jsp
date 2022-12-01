<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<meta charset="utf-8">
<title>User and Product management</title>

<h3>Accounts</h3>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                    	<c:forEach items="${accs}" var="acc" varStatus="Stt">	                    
	                        <div class="col-sm">
	                            <div class="card">
	                                <img class="card-img-top" src="${acc.images}" alt="Card image cap" width="600" height="280">
	                                <div class="card-body">
	                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/admin/account/status?accid=${acc.userId}" title="View Product">${acc.username }</a></h4>
	                                    <p class="card-text">${acc.email}</p>
	                                    <div class="row">
	                                        <div class="col">
	                                            <p>${acc.status}</p>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Product
                </div>
                <div class="card-body">
                    <div class="row">
                    	<c:forEach items="${pros }" var="product" varStatus="Stt">	  
                    	<c:if test="${product.status == 0}">
	                        <div class="col-sm-12 col-md-6 col-lg-4">
	                            <div class="card">
	                                <img class="card-img-top" src="${product.images }" alt="Card image cap" width="600" height="280">
	                                <div class="card-body">
	                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/common/product/detail?productId=${product.productId }" title="View Product">${product.productName }</a></h4>
	                                    <p class="card-text">${product.description}</p>
	                                    <div class="row">
	                                        <div class="col">
	                                            <p>Giá: ${product.price}</p>
	                                 
	                                        </div>
	                                        <div class="col">
	                                            <p>Trạng thái: ${product.status} </p>
	                                 
	                                        </div>
	                                        
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
                    	</c:if>
                    	                  
                    	<c:if test="${product.status == 1}">
	                        <div class="col-sm-12 col-md-6 col-lg-4">
	                            <div class="card bg-secondary">
	                                <img class="card-img-top" src="${product.images }" alt="Card image cap" width="600" height="280">
	                                <div class="card-body">
	                                    <h4 class="card-title"><a href="#" title="View Product" class=" text-dark">${product.productName }</a></h4>
	                                    <p class="card-text">Locked by admin</p>
	                                    <div class="row">
	                                        <div class="col">
	                                            <p>Giá: ${product.price}</p>
	                                 
	                                        </div>
	                                        <div class="col">
	                                            <p>Trạng thái: ${product.status} </p>
	                                 
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
