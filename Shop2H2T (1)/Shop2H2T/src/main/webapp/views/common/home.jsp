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
	
<div class="container mt-5 mb-4">
    <div class="row">
		<div class="col-lg-2 col-md-12 col-sm-12 mb-4">			
			<h2>
				Categories<span class="btn btn-sm btn-light"><i class="fa fa-filter" type="button" data-toggle="collapse"
				data-target="#collapseExample" aria-expanded="false"
				aria-controls="collapseExample">
				</i></span>
			</h2>
			<div class="collapse" id="collapseExample">
				<ul class="list-group">
					<c:forEach items="${categories}" var="category" varStatus="Stt">
						<li class="list-group-item">
							<a href="<%=request.getContextPath() %>/common/product/filter?categoryId=${category.categoryId }&categoryName=${category.categoryName}">
								${category.categoryName}
							</a>
						</li>						
					</c:forEach>      
				</ul>
			</div> 
		</div>
        <div class="col-lg-10 col-md-12 col-sm-12">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Last products for
                </div>
                <div class="card-body">
                    <div class="row">
                    	<c:forEach items="${productList }" var="product" varStatus="Stt">	 
                    		<c:if test="${product.status == 0}">                   
		                        <div class="col-lg-4 col-md-6 col-sm-12 my-2">
		                            <div class="card">
		                                <img class="card-img-top" src="${product.images }" alt="Card image cap" width="600" height="280">
		                                <div class="card-body">
		                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/common/product/detail?productId=${product.productId }" title="View Product">${product.productName }</a></h4>
		                                    <c:if test="${product.description.length() < 201}">
		                                    <p class="card-text">${product.description}</p>
		                                    </c:if>
		                                    
		                                    <c:if test="${product.description.length() >= 201}">
		                                    <p class="card-text">${product.description.substring(0,200)}...</p>
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
		                                            <a class="btn btn-warning btn-block">Add to cart</a>
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
	
<script type="text/javascript">
	window.onload = function() {
		let accountDisabled = ${accountDisabled};
		console.log(accountDisabled);
		console.log(typeof(accountDisabled));
		let orderSuccess = ${orderSuccess};
		console.log(orderSuccess);
		console.log(typeof(orderSuccess));
		
		if(accountDisabled === true)
		{
			alert("Đăng nhập thành công nhưng tài khoản đã bị khóa. Xin liên hệ admin");
		}
		if(orderSuccess === true)
		{
			alert("Đặt hàng thành công. Xin chờ admin duyệt hàng");
		}
	}
</script>	
<%-- <div class="container mt-3 mb-4">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-trophy"></i> Best selling products                    
                </div>
                <div class="card-body">
                	<a href="<%=request.getContextPath() %>/views/admin/product-insert.jsp" class="btn btn-dark">Insert new product</a>
                	<br>
                	<br>
                    <div class="row">
                    <c:forEach items="${bestSellingProducts }" var="bestSellingProduct" varStatus="STT">
                        <div class="col-sm">
                            <div class="card">
                                <img class="card-img-top" src="${bestSellingProduct.images }" alt="Card image cap" width="600" height="280">
                                <div class="card-body">
                                    <h4 class="card-title"><a href="<%=request.getContextPath() %>/user/product?productId=${bestSellingProduct.productId }" title="View Product">${cheapProduct.productName }</a></h4>
                                    <p class="card-text">${bestSellingProduct.description}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${bestSellingProduct.price } $</p>
                                        </div>
                                        <div class="col">
                                            <a href="<%=request.getContextPath() %>/user/cart?productId=${bestSellingProduct.productId }&action=addToCart" class="btn btn-success btn-block">Add to cart</a>
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
</div> --%>