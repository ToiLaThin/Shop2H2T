<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="container">
	<h3>All category</h3>
	<a class="btn btn-success" href="<%=request.getContextPath() %>/admin/category/insert">New Category</a>
	<br>
	<br>
	
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">CategoryId</th>
				<th scope="col">CategoryName</th>
				<th scope="col">Images</th>
				<th scope="col">Status</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories }" var="category" varStatus="STT">
				<tr scope="row">
					<td>${category.categoryId }</td>
					<td>${category.categoryName}</td>
					<td><img src="${category.images }" width="80" height="55" alt="category image"></td>
					<td>${category.status}</td>
					<td>
						<a class="btn btn-sm btn-danger" href="<%=request.getContextPath() %>/admin/category/update?categoryId=${category.categoryId }">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a class="btn btn-primary" href="<%=request.getContextPath() %>/common/home">Back</a>
	<br>
	<br>
	
</div>