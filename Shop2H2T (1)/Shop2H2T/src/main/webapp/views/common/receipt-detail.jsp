<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<div class="container  card shadow font-monospace my-4 p-4">
<c:set var = "finalPrice" value = "0"/>
<h2 class="font-monospace font-weight-bold m-0 p-0">Your invoice: </h2>
	<c:forEach items="${cart }" var="cartItem" varStatus="Stt">
		<c:set var = "productQuantityPrice" value = "${cartItem.product.price*cartItem.quantity}"/>
		<c:set var = "finalPrice" value = "${finalPrice + productQuantityPrice }"/>
	    <div class="p-0 m-0">
	        <div class="d-flex">
	            <p class="col-6">Product: ${cartItem.product.productName } <small>category:</small></p>
	            <p class="col-4">Price per unit: ${cartItem.product.price }</p>
	        </div>
	        <div class="d-flex">
	            <p class="col-6">Quantity: ${cartItem.quantity}</p>
	            <p class="col-4">Total: <c:out value = "${productQuantityPrice}"/></p>
	        </div>
	        <hr />
	    </div>
	    <br>
	</c:forEach>
	<h2 class="font-weight-bold m-0 p-0"
		style="font-family: Courier New, Courier, monospace;">
		Total: <b class="text-danger">Final price: <c:out
				value="${finalPrice}" /></b>
	</h2>
   	<small class="font-monospace text-sm-left">Release Date: ${releaseDate}</small>
</div>