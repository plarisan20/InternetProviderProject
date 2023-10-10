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
<link rel="stylesheet" type="text/css" href="/css/login-reg.css">
<title>User Registration</title>
</head>
<body>
	<div class="container">
	 	<h1>Register Account</h1>
	 	<!-- modelAttribute must be the same name on the Controller -->
		<form:form action="/register" method="post" modelAttribute="registerUser">
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
			<div class="confirmpassword">
				<form:label path="confirmedPassword"> Confirm Password: </form:label>
				<form:errors path="confirmedPassword"/>
				<form:password path="confirmedPassword"/>
			</div>
			
			<div class="button selection">
				<input class="backbutton" type="submit" value="Register"/>
				
				<div class="backbutton">
					<a href="/">Back</a>
				</div>
			
			</div>
		</form:form>
	</div>
	


</body>
</html>