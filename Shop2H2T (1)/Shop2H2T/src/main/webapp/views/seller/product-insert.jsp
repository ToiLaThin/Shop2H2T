<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="container mt-5 mb-5">
	<c:url value="/seller/product/insert" var="insertUrl"></c:url>
	<form method="post" action="${insertUrl }">
	  <div class="form-group">
	    <label for="productName">Product name:</label>
	    <input class="form-control" id="productName" placeholder="Enter product 's name" name="productName" required>
	  </div>
	  <div class="form-group">
	    <label for="productDescription">Product description:</label>
	    <input class="form-control" id="productDescription" placeholder="Description" name="productDescription">
	    <span class="text-warning">(Optional)</span>
	  </div>  
	  <div class="form-group">
	    <label for="productPrice">Product price:</label>
	    <input class="form-control" id="productPrice" placeholder="Price" name="productPrice" type="number" required>
	  </div>
	  <div class="form-group">
	    <label for="productStock">Product stock:</label>
	    <input class="form-control" id="productStock" placeholder="Stock" name="productStock" type="number" min="0" max="100" required> 
	  </div>
	  <div class="form-group">
	    <label for="productImage">Product image:</label>
	    <input class="form-control" id="productImage" placeholder="Image" name="productImage">
	    <span class="text-warning">(Optional)</span>
	  </div>
	  <div class="form-group">
	    <label for="productCreateDate">Create date:</label>
	    <input class="form-control" id="productCreateDate" placeholder="Create date" name="productCreateDate" type="date" required>
	  </div>
	  <div class="form-group">
          <label for="category">Categories</label>
          <select class="custom-select" id="category" name="categoryId">
          <c:forEach items="${categories }" var="category" varStatus="STT">
              <option value="${category.categoryId }">${category.categoryName }</option>
          </c:forEach>
          </select>
      </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	  <a class="btn btn-secondary" href="<%=request.getContextPath() %>/seller/home">Back</a>
	</form>
</div>
