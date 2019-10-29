<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>数据 - AdminLTE2定制版 | Log in</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="all-admin-index.html"><b>ITCAST</b>后台管理系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">登录系统</p>

			<form action="${pageContext.request.contextPath}/login.do" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="username" class="nameInput form-control"
						placeholder="用户名"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="passwordInput form-control"
						placeholder="密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<%--<label><input type="checkbox"> 记住 下次自动登录</label>--%>
							<a href="${pageContext.request.contextPath}/user/main.do">记住 下次自动登录</a>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<button onclick="checkFrom()">简单验证</button><br>


		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<!-- Bootstrap 3.3.6 -->
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});

        <%--//做一些简单的表单验证利用AJAX--%>
        <%--function checkFrom() {--%>
		    <%--var name = $(".nameInput").val();--%>
		    <%--var pwd = $(".passwordInput").val();--%>
		    <%--var json = {"name":name,"pwd":pwd};--%>
		    <%--if(name ==""||pwd ==""){--%>
		        <%--alert("姓名或者密码不能为空！");--%>
		        <%--return;--%>
			<%--}else {--%>
		        <%--alert("ajax之前");--%>
		        <%--$.ajax({--%>
					<%--type:"post",--%>
                    <%--contentType:"application/json;charset=UTF-8",//必须有--%>
					<%--url:"${pageContext.request.contextPath}/user/checkFrom.do",--%>
					<%--data:JSON.stringify(json),--%>
					<%--dataType:"json",--%>
					<%--success:function (map) {--%>
                        <%--alert("ajax成功");--%>
						<%--if(map.get("check")=="false"){--%>
						    <%--alert("用户名或密码输入错误");--%>
						<%--}--%>
                    <%--},--%>
                    <%--error:function (map) {--%>
                        <%--alert("ajax错误");--%>
                    <%--}--%>
				<%--})--%>

			<%--}--%>


        <%--}--%>
	</script>
</body>

</html>