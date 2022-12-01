<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<h2>Register Page</h2>
<c:url value="/user/registerSeller" var="registerSellerControllerUrl"></c:url>
<div>
	<form role="form" action="${registerSellerControllerUrl }" method="post">
		Mã số doanh nghiệp: <input type="text" name="maSoDoanhNghiep" placeholder="Nhập mã số doanh nghiệp của bạn:" class="form-control" required><br>		
		Mã số nội bộ: <input type="text" name="maSoNoiBo" placeholder="Nhập mã số nội bộ của bạn:" class="form-control" required><br>
		Tên doanh nghiệp: <input type="text" name="tenDoanhNghiep" placeholder="Nhập tên doanh nghiệp của bạn:" class="form-control" required><br>
		Tên cửa hàng: <input type="text" name="tenCuaHang" placeholder="Nhập tên shop của bạn:" class="form-control" required><br>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>


<script type="text/javascript">
	window.onload = function() {
		let registerSellerFailed = ${registerSellerFailed};
		console.log(registerSellerFailed);
		console.log(typeof(registerSellerFailed));
		
		if(registerSellerFailed === true)
		{
			alert("Không đăng ký thành công vì sai thông tin");
		}
	}
</script>