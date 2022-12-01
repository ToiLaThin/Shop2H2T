<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<title>${acc.username}</title>
	
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
					<a href="" data-toggle="modal" data-target="#productModal"> <img
						class="img-fluid" src="${acc.username }" />

					</a>
					<h2 class="text-center">${acc.fullname }</h2>
				</div>
			</div>
		</div>

		<!-- Add to cart -->
		<div class="col-12 col-lg-6 add_to_cart_block">
			<div class="card bg-light mb-3">
				<div class="card-body">
					<p class="price">${acc.status}</p>

					<a class="btn btn-success btn-sm ml-3"
						href="<%=request.getContextPath() %>/admin/user/changestatus0?userid=${acc.userId}">
						Active 
					</a> 
					<a class="btn btn-success btn-sm ml-3"
						href="<%=request.getContextPath() %>/admin/user/changestatus1?userid=${acc.userId}">
						Negative 
					</a>
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
	                        Non
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