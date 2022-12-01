<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/55595c/fff" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/a30ca3/fff" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/1443ff/fff" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">
            <div class="card">
                <div class="card-header bg-success text-white text-uppercase">
                    <i class="fa fa-heart"></i> Top product
                </div>
                <img class="img-fluid border-0" src="https://dummyimage.com/600x400/55595c/fff" alt="Card image cap">
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="product.html" title="View Product">Product title</a></h4>
                    <div class="row">
                        <div class="col">
                            <p class="btn btn-danger btn-block">99.00 $</p>
                        </div>
                        <div class="col">
                            <a href="product.html" class="btn btn-success btn-block">View</a>
                        </div>
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
                    <i class="fa fa-star"></i> My Shop
                </div>
                <div class="card-body">
                    <div class="row">
                    	<c:forEach items="${productListOfSeller }" var="product" varStatus="Stt">	                    
	                        <c:if test="${product.status == 0}">                   
		                        <div class="col-lg-4 col-md-6 col-sm-12 my-2">
		                            <div class="card">
		                                <img class="card-img-top" src="${product.images }" alt="Card image cap" width="600" height="280">
		                                <div class="card-body">
		                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/common/product/detail?productId=${product.productId }" title="View Product">${product.productName }</a></h4>
		                                    <p class="card-text">${product.description}</p>
		                                    <div class="row">
		                                        <div class="col">
		                                            <p class="btn btn-danger btn-block">${product.price} $</p>
		                                        </div>
		                                        <div class="col">		                                            
		                                            <a class="btn btn-success btn-block" href="<%=request.getContextPath() %>/seller/product/update?productId=${product.productId}">Update</a>
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
		                                    <h4 class="card-title"><a class="text-dark" href="<%=request.getContextPath() %>/common/product/detail?productId=${product.productId }" title="View Product">${product.productName }</a></h4>
		                                    <p class="card-text">Locked by admin</p>
		                                    <div class="row">
		                                        <div class="col">
		                                            <p class="btn btn-danger btn-block">${product.price} $</p>
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
<a href="<%=request.getContextPath() %>/seller/product/insert" class="btn btn-dark">Insert new product</a>
<br>
<br>