<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!-- this JSP should be the first page to show up -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EC Internet Provider</title>
<link rel="stylesheet" type="text/css" href="/css/webpage.css">
</head>
<body>
<div>
	<!-- put this as the nav -->
	<header>
		<!-- NAV -->
		<div class="nav">
			<ul>
				<li> <a href="/"> Home</a></li>
				
				<li> <a href="/register"> Sign Up</a></li>
				<li> <a href="/login"> Log in</a></li>
			</ul>
		</div>
	</header>
		<hr class="breakline">
	<!-- Body -->
	<article>
		<div>
			<h4>EC Internet Plan and Pricing</h4>
			<h2>Experience the power of this provider</h2>
			<h5>Fast, reliable speeds and delivers up to GiG of download speed </h5>
			<!-- Put a picture here about the Product -->
		</div>
	</article>
	<hr class="breakline">
	
	
		<div id="planselection" >
			<div class="plan">
			    <div class="planspeed">
			        <div class="100Plan">
			            <p>100 Mbps</p>
			            <p>Fast Speed</p>
			            <p>with 1250 Gb Data Plan</p>
			        </div>
			    </div>
			
			    <div class="planprice">
			        <p>Plan Price</p>
			        <p>$19.99/month</p>
			    </div>
			</div>
			
			<div class="plan">
			    <div class="planspeed">
			        <div class="250Plan">
			            <p>250 Mbps</p>
			            <p>Faster Speed</p>
			            <p> with unlimited Data Plan</p>
			        </div>
			    </div>
			
			    <div class="planprice">
			        <p>Plan Price</p>
			        <span>$24.99/month</span>
			    </div>
			</div>
			
			<div class="plan">
			    <div class="planspeed">
			        <div class="500Plan">
			            <p>500 Mbps</p>
			            <p>Even Faster Speed</p>
			            <p> with unlimited Data Plan</p>
			        </div>
			    </div>
			
			    <div class="planprice">
			        <p>Plan Price</p>
			        <p>$35.99/month</p>
			    </div>
			</div>
			
			<div class="plan">
			    <div class="planspeed">
			        <div class="1GPlan">
			            <p>1 GiG</p>
			            <p>Super Fast Speed</p>
			            <p> with unlimited Data Plan</p>
			        </div>
			    </div>
			
			    <div class="planprice">
			        <p>Plan Price</p>
			        <p>$44.99/month</p>
			    </div>
			</div>

		
		</div>
	
		
	

</div>



</body>
</html>