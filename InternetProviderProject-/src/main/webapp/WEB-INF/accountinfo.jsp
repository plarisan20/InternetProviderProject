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
<title>My Account</title>
<link rel="stylesheet" type="text/css" href="/css/accountinfo.css">
</head>
<body>
	<div class="nav">
		<h1>Hello, <c:out value="${ thisUserPlan.firstname }"/> <c:out value="${ thisUserPlan.lastname }"/> </h1>
		 
		<ul>
			<li><a href="/plan/account/${thisUserPlan.id }">Home</a></li>
			<!-- when clicking products, it would show up the products sample -->
			<!-- when clicking My Account, it would go straight to Account's Info -->
			<li><a href="/logout">Log out</a></li>
		</ul>
		
	
	</div>

		<!-- Account info -->
		<!-- this is only for the created User only -->
	<div id="accountbillingcontainer">
	<c:if test="${loggedUser.id == thisUserPlan.planCreator.id }" >
		<div class="account-info">
			<h2>My Account</h2>
				<div class="accnumber">
					<p><strong>Account number</strong> </p>
					<p>001 8080 21<c:out value="${thisUserPlan.id }"/></p>
				</div>
				
				<div class="address">
					<p><strong>My address</strong> </p>
					<p><c:out value="${thisUserPlan.address }"/></p>
				</div>
				
				<div class="phonenumber">
					<p><strong>Phone number</strong> </p>
					<p><c:out value="${thisUserPlan.phonenumber }"/></p>
				</div>
					<a href="/plan/edit/${thisUserPlan.id}">Edit Account Info</a>
				<form method="post" action="/plan/delete/${thisUserPlan.id}">
				<!-- set it up like this in order for delete button to work 
				<input type="hidden" name="_method" value="delete"/> -->
					<div>
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Delete"/>
					</div>			
				</form>
				
		</div>
		</c:if>		
				
			
			<!-- Billing info -->
		<div class="billing-info">
			<h2>Billing</h2>
				<div>
					<p>Your Monthly Bill is</p>
					<h3> $<c:out value="${thisUserPlan.price }"/>/Month</h3>
				</div>
				
			<!-- It should show here how much is the monthly bill -->
			<!-- and it should do an edit that the user could change the plan that they have -->
		</div>
	</div>
	

</body>
</html>