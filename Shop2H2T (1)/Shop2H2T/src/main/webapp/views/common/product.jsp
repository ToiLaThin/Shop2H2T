<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${product.productName}</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col">
	            <nav aria-label="breadcrumb">
	                <ol class="breadcrumb">
	                    <li class="breadcrumb-item"><a href="<%=request.getContextPath() %>/common/home">Home</a></li>
	                    <li class="breadcrumb-item"><a href="category.html">Category</a></li>
	                    <li class="breadcrumb-item active" aria-current="page">Product</li>
	                </ol>
	            </nav>
	        </div>
	    </div>
	</div>
	<%-- <ul class="list-group margin-bottom-25 sidebar-menu">
		<c:forEach items="${categoryList}" var="category">
			<li class="list-group-item clearfix"><a
				href="<c:url value="/product/list?categoryid=${category.cateId }"/>">
					<img
					src="<c:url value="/image?fname=category/${category.images}"/>"
					class="img-circle" width="22px"> ${category.cateName}
			</a></li>
		</c:forEach>
	</ul> --%>
	<div class="container">
	    <div class="row">
	        <!-- Image -->
	        <div class="col-12 col-lg-6">
	            <div class="card bg-light mb-3">
	                <div class="card-body">
	                    <a href="" data-toggle="modal" data-target="#productModal">
	                        <img class="img-fluid" src="${product.images }" />
	                        <p class="text-center">Zoom</p>
	                    </a>
                        <h2 class="text-center">${product.productName }</h2>
	                </div>
	            </div>
	        </div>
	
	        <!-- Add to cart -->
	        <div class="col-12 col-lg-6 add_to_cart_block">
	            <div class="card bg-light mb-3">
	                <div class="card-body">
	                    <p class="price">${product.price } $</p>
	                    <p class="price_discounted">149.90 $</p>
	                    <form method="get" action="cart.html">
	                        <div class="form-group">
	                            <label for="colors">Color</label>
	                            <select class="custom-select" id="colors">
	                                <option selected>Select</option>
	                                <option value="1">Blue</option>
	                                <option value="2">Red</option>
	                                <option value="3">Green</option>
	                            </select>
	                        </div>
							<div class="form-group">
								<label>Quantity in your cart:</label>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<button type="button"
											class="quantity-left-minus btn btn-danger btn-number"
											data-type="minus" data-field=""
											onclick="func_SubtractProductQuantityByOne()">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<%--  ${product.stock }--%>
									<input type="text" class="form-control" id="quantity"
										name="quantity" min="0" max="${productAmountInInventory }"
										value="${productQuantityInCart }" readonly>
									<div class="input-group-append">
										<button type="button"
											class="quantity-right-plus btn btn-success btn-number"
											data-type="plus" data-field=""
											onclick="func_AddProductQuantityByOne()">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
							</div>
							<c:if test="${ userRole.equalsIgnoreCase('admin')}">
								<p>Trang thái:</p>
								<c:if test="${ product.status==1}">
									<p>Bị vô hiệu hóa</p>
								</c:if>
								<c:if test="${ product.status==0}">
									<p>Được phép bán</p>
								</c:if>
							</c:if>
							<c:if test="${ userRole.equalsIgnoreCase('admin')}">
								<a class="btn btn-success btn-sm ml-3"
									href="<%=request.getContextPath() %>/admin/product/changestatus?productId=${product.productId }">
									Change status </a>
								<br>
								<br>
							</c:if>
							<c:if test="${ product.status == 0}">
								<button class="btn btn-success btn-lg btn-block text-uppercase"
									id="updateProductQuantityBtn"
									onclick="func_changeProductQuantityInCart()" type="button">
									<i class="fa fa-shopping-cart"></i> Update To Cart
								</button>
								<br>
								<div class="row">
                                    <div class="col">		                                        
						               	<c:if test="${username != null }">
						                    <c:set var = "isLogin" value = "true"/>
						               	</c:if>
						               	<c:if test="${username == null }">
						                    <c:set var = "isLogin" value = "false"/>
						               	</c:if>
						               	<c:if test="${isLogin == true }">
						                    <a href="<%=request.getContextPath() %>/common/buyNow?productId=${product.productId }" class="btn btn-primary btn-block btn-lg text-uppercase">Buy now</a>
						               	</c:if>
						               	<c:if test="${isLogin == false }">
						                    <a href="<%=request.getContextPath() %>/views/common/login.jsp" class="btn btn-primary btn-block btn-lg text-uppercase">Buy now</a>
						               	</c:if>
                                    </div>
                                </div>
							</c:if>
						</form>
	                    <div class="product_rassurance">
	                        <ul class="list-inline">
	                            <li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br/>Fast delivery</li>
	                            <li class="list-inline-item"><i class="fa fa-credit-card fa-2x"></i><br/>Secure payment</li>
	                            <li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br/>+33 1 22 54 65 60</li>
	                        </ul>
	                    </div>
	                    <div class="reviews_product p-3 mb-2 ">
	                        3 reviews
	                        <i class="fa fa-star"></i>
	                        <i class="fa fa-star"></i>
	                        <i class="fa fa-star"></i>
	                        <i class="fa fa-star"></i>
	                        <i class="fa fa-star"></i>
	                        (4/5)
	                        <a class="pull-right" href="#reviews">View all reviews</a>
	                    </div>
	                    <div class="datasheet p-3 mb-2 bg-info text-white">
	                        <a href="" class="text-white"><i class="fa fa-file-text"></i> Download DataSheet</a>
	                    </div>
	                    <h5>Created On: ${product.modifiedDate} </h5>	                   
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <div class="row">
	        <!-- Description -->
	        <div class="col-12">
	            <div class="card border-light mb-3">
	                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-align-justify"></i> Description</div>
	                <div class="card-body">
	                    <p class="card-text">
	                        ${product.description }
	                    </p>
	                    
	                </div>
	            </div>
	        </div>
	
	        <!-- Reviews -->
	        <div class="col-12" id="reviews">
	            <div class="card border-light mb-3">
	                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-comment"></i> Reviews</div>
	                <div class="card-body">
	                    <div class="review">
	                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
	                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2018
	
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        by Paul Smith
	                        <p class="blockquote">
	                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	                        </p>
	                        <hr>
	                    </div>
	                    <div class="review">
	                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
	                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2018
	
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        by Paul Smith
	                        <p class="blockquote">
	                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	                        </p>
	                        <hr>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	
	
	
	<script>		
		let maxQuantityInt = parseInt(document.getElementById("quantity").max, 10);
		let minQuantityInt = parseInt(document.getElementById("quantity").min, 10);
		const func_AddProductQuantityByOne = function(){
			const element = document.getElementById("quantity");
			let quantityString = element.value;
			quantityInt = parseInt(quantityString,10) + 1;
			
			if(quantityInt > maxQuantityInt){
				alert("Hết hàng")	
			}
			else{
				element.value = quantityInt.toString();					
			}
		}
		const func_SubtractProductQuantityByOne = function(){
			const element = document.getElementById("quantity");	
			let quantityString = element.value;
			quantityInt = parseInt(quantityString,10) - 1;
			
			if(quantityInt < minQuantityInt){
				alert("Số lượng không hợp lệ");	
			}
			else{
				element.value = quantityInt.toString();					
			}
		}
		
		const func_changeProductQuantityInCart = function() {
			var changedProductQuantityInCart = document.getElementById("quantity").value;
			if(changedProductQuantityInCart > 0)
			{
				var pId = ${product.productId};
				console.log("Hello");
				var root = "${pageContext.request.contextPath}"
				window.location.href = root + "/common/cart?productId=" + pId + "&action=updateToCart&productQuantity=" + changedProductQuantityInCart;			
			}
			else
			{
				alert("Chưa mua hàng");	
			}
		};
	</script>
	
</body>
</html>