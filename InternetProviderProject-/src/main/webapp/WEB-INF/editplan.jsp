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
<title>Edit Plan</title>
<link rel="stylesheet" type="text/css" href="/css/webpage.css">
</head>
<body>	
	<h2>Edit your Account</h2>
	
	<form:form action="/plan/editDB/${thisUserPlan.id}" method="POST" modelAttribute="thisUserPlan">
			<!--  this is needed in order to use PutMapping -->
		<input type="hidden" name="_method" value="PUT"/>
		
		<div id="editaccountplan">
			<div class="plan">
				<form:radiobutton path="price" value="19.99"/>
			    <form:label path="price">100 Mbps</form:label>
			    <p>Fast Speed</p>
			    <p>$19.99/month</p>
			</div>
			<div class="plan">
				<form:radiobutton path="price" value="24.99"/>
			    <form:label path="price">250 Mbps</form:label>
			    <p>Faster Speed</p>
			    <p>$24.99/month</p>
			</div>
			<div class="plan">
				<form:radiobutton path="price" value="35.99"/>
			    <form:label path="price">500 Mbps </form:label>
			    <p>Even Faster Speed</p>
			    <p>$35.99/month</p>
			</div>
			<div class="plan">
				<form:radiobutton path="price" value="44.99"/>
			    <form:label path="price">100 GiG</form:label>
			    <p>Super Fast Speed</p>
			    <p>$44.99/month</p>
			</div>
		</div>
			<hr class="breakline">
			<div class="accountInfo">
				<div class="firstname">
			        <form:errors path="firstname"></form:errors>
			        <form:label path="firstname">First Name:</form:label>
			        <form:input path="firstname"/>
			    </div>
			    <div class="lastname">
			        <form:errors path="lastname"></form:errors>
			        <form:label path="lastname">Last Name:</form:label>
			        <form:input path="lastname"/>
			    </div>
				<div class="address">
			        <form:errors path="address"></form:errors>
			        <form:label path="address">Address:</form:label>
			        <form:input path="address"/>
			    </div>
			    <div class="phonenumber">
			        <form:errors path="phonenumber"></form:errors>
			        <form:label path="phonenumber">Phone Number:</form:label>
			        <form:input path="phonenumber"/>
			    </div>
			</div>
		    <!-- this is needed in order to know in the form that this is the user that is log in and passing the form -->
			<form:input type="hidden" path="planCreator" value="${loggedUser.id}"/>
			
			<input type="submit" value="Select Plan">
		
	</form:form>
	
		<a href="/plan/account/${thisUserPlan.id}">Cancel</a>
		
	
</body>
</html>