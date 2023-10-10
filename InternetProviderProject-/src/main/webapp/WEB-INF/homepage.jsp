<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!-- HOMEPAGE -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/webpage.css">
</head>
<body>
	<div class="nav">
		<h1>PUT A HOMEPAGE OF THE INTERNET PROVIDER</h1>
		<h2>Welcome, New Costumer!</h2>
		<h3>Select the best plan for you!</h3>
		<a href="/">Log out</a>
	</div>
		<hr class="breakline">	
	
<form:form action="/plan/checkout" method="POST" modelAttribute="newUserPlan">

	<div class="container">
	<!-- Select plan cost -->
	<!-- in order to get the price, you have to put the value number on the radio button -->
		<h2>Select your plan</h2>
		<div id="homepageplan" >
			<div class="plan">
				<form:radiobutton path="price" value="19.99"/>
			    <form:label path="price"></form:label>
			    <p>100 Mbps</p>
			    <p>Fast Speed</p>
			    <span>$19.99/month</span>
			</div>
			<div class="plan">
				<form:radiobutton path="price" value="24.99"/>
			    <form:label path="price"></form:label>
			    <p>250 Mbps</p>
			    <p>Faster Speed</p>
			    <span>$24.99/month</span>
			</div>
			<div class="plan">
				<form:radiobutton path="price" value="35.99"/>
			    <form:label path="price"></form:label>
			    <p>500 Mbps</p>
			    <p>Even Faster Speed</p>
			    <span>$35.99/month</span>
			</div>
			<div class="plan">
				<form:radiobutton path="price" value="44.99"/>
			    <form:label path="price"></form:label>
			    <p>1 GiG</p>
			    <p>Super Fast Speed</p>
			    <span>$44.99/month</span>
			</div>
		</div>
		
		<hr class="breakline">
		<h2>Account Info</h2>
		<div class="accountInfo">
		    <div class="firstname">
		        <form:label path="firstname">First Name:</form:label>
		        <form:errors path="firstname"></form:errors>
		        <form:input path="firstname"/>
		    </div>
		    <div class="lastname">
		        <form:label path="lastname">Last Name:</form:label>
		        <form:errors path="lastname"></form:errors>
		        <form:input path="lastname"/>
		    </div>
		    <div class="address">
		        <form:label path="address">Address:</form:label>
		        <form:errors path="address"></form:errors>
		        <form:input path="address"/>
		    </div>
		    <div class="phonenumber">
		        <form:label path="phonenumber">Phone Number:</form:label>
		        <form:errors path="phonenumber"></form:errors>
		        <form:input path="phonenumber"/>
		    </div>
		</div>
	</div>

	    <!-- this is needed in order to know in the form that this is the user that is log in and passing the form -->
		<form:input type="hidden" path="planCreator" value="${loggedUser.id}"/>

        <input type="submit" value="Select Plan">
    </form:form>
	
	
	

	
</body>
</html>