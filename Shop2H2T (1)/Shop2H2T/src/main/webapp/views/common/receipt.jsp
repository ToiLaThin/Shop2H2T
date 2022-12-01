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
	</tr>
	<c:forEach items="${waitingCartsOfUser }" var="cart" varStatus="cartSTT">
		<tr class="row">
			<td>Cart${cart.cartId }</td>
			<td>User${cart.userId }</td>
			<td>${cart.buyDate }</td>
			<td>${cart.status }</td>
			<td>${cart.address }</td>
			<td>${cart.phoneNumber }</td>
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
	<c:forEach items="${validCartsOfUser }" var="cart" varStatus="cartSTT">
		<tr class="row">
			<td>Cart${cart.cartId }</td>
			<td>User${cart.userId }</td>
			<td>${cart.buyDate }</td>
			<td>${cart.status }</td>
			<td>${cart.address }</td>
			<td>${cart.phoneNumber }</td>
			<td>
				<a class="btn btn-sm btn-danger" href="<%=request.getContextPath() %>/common/order/checkout?cartId=${cart.cartId}&buyDate=${cart.buyDate}">Checkout</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<br>

<!-- receipt co the xem chi tiet duoc -->
<h3>Receipts</h3>
<table class="table table-danger">
	<tr class="row">
		<th>receiptId</th>
		<th>releaseDate</th>
		<th>cartId</th>		
		<th>Action</th>	
	</tr>
	<c:forEach items="${receiptsOfUser }" var="receipt" varStatus="receiptSTT">
		<tr class="row">
			<td>Receipt${receipt.receiptId }</td>
			<td>${receipt.releaseDate }</td>
			<td>${receipt.cartId }</td>
			<td><a class="btn btn-sm btn-warning" href="<%=request.getContextPath() %>/common/order/detail?cartId=${receipt.cartId}&receiptId=${receipt.receiptId}">View</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<a class="btn btn-primary" href="<%=request.getContextPath() %>/common/home">Back</a>

<script type="text/javascript">
	window.onload = function() {
		let isOutOfOneProduct = ${isOutOfOneProduct};
		console.log(isOutOfOneProduct);
		console.log(typeof(isOutOfOneProduct));
		
		if(isOutOfOneProduct  === true)
			{
				alert("Có một mặt hàng bạn đặt đã hết xin đợi tới khi hàng về");
				/* let root = "${pageContext.request.contextPath}"				
				window.location.href = root + "/common/home"; */
			}
	}
</script>