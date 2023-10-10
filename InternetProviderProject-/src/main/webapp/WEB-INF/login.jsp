<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="/css/login-reg.css">
</head>
<body>
	<div class="container">
		<h1>Log in</h1>
		<!-- modelAttribute must be the same name on the Controller -->
		
		<form:form action="/login" method="post" modelAttribute="loginUser">
		
			<div class="username">
				<form:label path="userName"> Username: </form:label>
				<form:errors path="userName"/>
				<form:input path="userName"/>
			</div>
			<div class="password">
				<form:label path="password"> Password: </form:label>
				<form:errors path="password"/>
				<form:password path="password"/>
			</div>
			
			<div class="button selection" >
				
				<input class="backbutton" type="submit" value="Log In"/>
			
				<div class="backbutton">
					<a href="/">Back</a>
				</div>
			
			</div>
		</form:form>
	</div>

</body>
</html>