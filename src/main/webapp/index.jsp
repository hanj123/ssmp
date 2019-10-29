<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<body>
<jsp:forward page="${pageContext.request.contextPath}/user/main.do?username=${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}&model=null&password=${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.password}"></jsp:forward>
</body>
</html>
