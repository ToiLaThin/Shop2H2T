<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="container mt-5 mb-5">
	<c:url value="/seller/product/update" var="updateUrl"></c:url>
	<form method="post" action="${updateUrl }">
		<input name="productId" value="${product.productId }" type="hidden">
		<input name="productStatus" value="${product.status }" type="hidden">
	  <div class="form-group">
	    <label for="productName">Product name:</label>
	    <input class="form-control" id="productName" name="productName" value="${product.productName }" required>
	  </div>
	  <div class="form-group">
	    <label for="productDescription">Product description:</label>
	    <input class="form-control" id="productDescription" value="${product.description }" name="productDescription">
	    <span class="text-warning">(Optional)</span>
	  </div>  
	  <div class="form-group">
	    <label for="productPrice">Product price:</label>
	    <input class="form-control" id="productPrice" value="${product.price }" name="productPrice" type="number" required>
	  </div>
	  <div class="form-group">
	    <label for="productStock">Product stock:</label>
	    <input class="form-control" id="productStock" value="${productStock }" name="productStock" type="number" min="0" max="100" required>
	  </div>
	  <div class="form-group">
	    <label for="productImage">Product image:</label>
	    <input class="form-control" id="productImage" value="${product.images }" name="productImage">
	    <span class="text-warning">(Optional)</span>
	  </div>
	  <div class="form-group">
	    <label for="productModifiedDate">Modified date:</label>
	    <input class="form-control" id="productModifiedDate" value="${product.modifiedDate }" name="productModifiedDate" type="date" required>
	  </div>
	   <div class="form-group">
          <label for="category">Categories</label>
          <select class="custom-select" id="category" name="categoryId">
          <c:forEach items="${categories }" var="category" varStatus="STT">
          	<c:if test="${category.categoryId == product.categoryId }">
              <option value="${category.categoryId }" selected>${category.categoryName }</option>
          	</c:if>
          	
          	<c:if test="${category.categoryId != product.categoryId }">
              <option value="${category.categoryId }">${category.categoryName }</option>
          	</c:if>
          	
          </c:forEach>
          </select>
      </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	  <a class="btn btn-secondary" href="<%=request.getContextPath() %>/seller/home">Back</a>
	</form>
</div>
