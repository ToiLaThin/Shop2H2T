<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="container mt-5 mb-5">
	<c:url value="/admin/category/update" var="updateCategoryUrl"></c:url>
	<form method="post" action="${updateCategoryUrl }">
	  <input name="categoryId" type="hidden" value="${category.categoryId }">
	  <div class="form-group">
	    <label for="categoryName">Category name:</label>
	    <input class="form-control" id="categoryName" value="${category.categoryName }" name="categoryName">
	  </div>
	  <div class="form-group">
	    <label for="categoryImage">Category image 's url:</label>
	    <input class="form-control" id="categoryImage" value="${category.images }" name="categoryImage">
	  </div>  
	  <button type="submit" class="btn btn-primary">Submit</button>
	  <a class="btn btn-secondary" href="<%=request.getContextPath() %>/admin/category/list">Back</a>
	</form>
</div>
