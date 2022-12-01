<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>

<h3>Cart Waiting</h3>
<table class="table table-warning">
	<tr class="row">
		<th>CartId</th>
		<th>UserId</th>
		<th>Buy Date</th>
		<th>Status</th>
		<th>Address</th>
		<th>PhoneNumber</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${waitingCarts }" var="cart" varStatus="cartSTT">
		<tr class="row">
			<td>Cart${cart.cartId }</td>
			<td>User${cart.userId }</td>
			<td>${cart.buyDate }</td>
			<td>${cart.status }</td>
			<td>${cart.address }</td>
			<td>${cart.phoneNumber }</td>
			<td>
				<a class="btn btn-sm btn-danger" href="<%=request.getContextPath() %>/admin/cart/change/inValid?cartId=${cart.cartId}">Mark Invalid</a>
				<a class="btn btn-sm btn-success" href="<%=request.getContextPath() %>/admin/cart/change/valid?cartId=${cart.cartId}">Mark Valid</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<br>

<h3>Cart Accepted</h3>
<table class="table table-success">
	<tr class="row">
		<th>CartId</th>
		<th>UserId</th>
		<th>Buy Date</th>
		<th>Status</th>
		<th>Address</th>
		<th>PhoneNumber</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${validCarts }" var="cart" varStatus="cartSTT">
		<tr class="row">
			<td>Cart${cart.cartId }</td>
			<td>User${cart.userId }</td>
			<td>${cart.buyDate }</td>
			<td>${cart.status }</td>
			<td>${cart.address }</td>
			<td>${cart.phoneNumber }</td>
			<td>
				<a class="btn btn-sm btn-danger" href="<%=request.getContextPath() %>/admin/cart/change/inValid?cartId=${cart.cartId}">Mark Invalid</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<br>

<h3>Cart Declined</h3>
<table class="table table-danger">
	<tr class="row">
		<th>CartId</th>
		<th>UserId</th>
		<th>Buy Date</th>
		<th>Status</th>
		<th>Address</th>
		<th>PhoneNumber</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${inValidCarts }" var="cart" varStatus="cartSTT">
		<tr class="row">
			<td>Cart${cart.cartId }</td>
			<td>User${cart.userId }</td>
			<td>${cart.buyDate }</td>
			<td>${cart.status }</td>
			<td>${cart.address }</td>
			<td>${cart.phoneNumber }</td>
			<td>
				<a class="btn btn-sm btn-success" href="<%=request.getContextPath() %>/admin/cart/change/valid?cartId=${cart.cartId}">Mark Valid</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<a class="btn btn-primary" href="<%=request.getContextPath() %>/common/home">Back</a>