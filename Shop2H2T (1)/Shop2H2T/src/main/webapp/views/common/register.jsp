<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url value="/common/register" var="registerControllerUrl"></c:url>
<div class="container card mt-2 mb-5 p-3 border-rounded">
	<h2>Register Page</h2>
	<form role="form" action="${registerControllerUrl }" method="post">
		<div class="form-group">
			Yourname: <input class="form-control" type="text" name="fullname" placeholder="Nhập tên của bạn:" required><br>
		</div>	
		<div class="form-group">
			Email: <input class="form-control" type="email" name="email" placeholder="Nhập email của bạn:" required><br>
		</div>	
		<div class="form-group">
			Phone number: <input class="form-control" type="tel" name="phone" placeholder="Nhập số điện thoại của bạn với format: 0[0-9]{9} " required pattern="0[0-9]{9}"><br>
		</div>		
		<div class="form-group">
			Account name: <input class="form-control" type="text" name="username" placeholder="Nhập username của bạn:" required><br>
		</div>	
		<div class="form-group">	
			Password: <input class="form-control" type="password" name="password" placeholder="Nhập password của bạn:" required><br>
		</div>
		<div class="form-group">
			Confirmed password: <input class="form-control" type="password" name="confirmedPassword" placeholder="Xác nhận lại password đã nhập" required><br>
		</div>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>

<script type="text/javascript">
	window.onload = function() {
		let passwordsMismatch = ${passwordsMismatch};
		console.log(passwordsMismatch);
		console.log(typeof(passwordsMismatch));
		
		if(passwordsMismatch === true)
		{
			alert("Không đăng ký thành công vì xác nhận tài khoản sai");
		}
	}
</script>