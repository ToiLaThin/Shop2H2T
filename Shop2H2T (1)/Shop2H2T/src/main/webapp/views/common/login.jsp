<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url value="/common/login" var="loginControllerUrl"></c:url>
<div class="container card mt-2 mb-5 p-3 border-rounded">
	<h2>Login Page</h2>
	<form role="form" action="${loginControllerUrl }" method="post">
		<div class="form-group">
			Username: <input class="form-control" type="text" name="username" placeholder="Nhập username của bạn:" required><br>
		</div>
		<div class="form-group">				
			Password: <input class="form-control" type="password" name="password" placeholder="Nhập password của bạn:" required><br>
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
</div>

<script type="text/javascript">
	window.onload = function() {
		let registerSuccess = ${registerSuccess}; 
		let loginFailed = ${loginFailed};
		let registerSellerSuccess = ${registerSellerSuccess}
		console.log(registerSuccess);
		console.log(typeof(registerSuccess));
		console.log(loginFailed);
		console.log(typeof(loginFailed));
		console.log(registerSellerSuccess);
		console.log(typeof(registerSellerSuccess));
		
		if(registerSuccess === true) { alert("Đăng ký user mới thành công");}
		if(loginFailed === true) { alert("Đăng nhập không thành công vì sai thông tin mật khẩu hoặc tên tài khoản");}
		if(registerSellerSuccess === true) { alert("Mở shop thành công");}
		
	}
</script>