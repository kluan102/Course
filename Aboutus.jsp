<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.user.Customer" %>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<% Customer customer = (Customer) session.getAttribute("customer"); %>  
<% ArrayList <String> transaction = (ArrayList<String>) session.getAttribute("transaction"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
</head>
<body>
	<div class="header">
			<form action="LogOutServlet" method="post" ><a href="index.jsp"><img src="BankLogo1.jpg" height="40" width="150" class="main headerpic"></a></form> 
			<div class="aboutus"><a href="Aboutus.jsp">About Us</a></div>
			<div class="location"><a href="Location.jsp">Location</a></div>
	</div>
		<br><br><br>
	<div class="explaination">
		<div style="font-size: 20px;">ABOUT M.O. MONEY BANK</div> <br><br>
		<div style="font-size: 55px;">Building your trust every day</div>
	</div>	
	<div>
		<img src="aboutus.jpeg" id="mainPIC" width="1265" height="500" class="main">
	</div>
	
	<div class="midway">
		<div class="inner"><div style="font-weight: bold;">Our company</div> <br>
		Our relationships are built on trust that we build every day through every interaction. Our employees are empowered to do the right thing to ensure they share our customers’ vision for success. We work as a partner to provide financial products and services that make banking safe, simple and convenient. We’re here to help navigate important milestones and strengthen futures together.
	</div>
	</div>
	
	<div style="position: absolute; top: 150%; color: black;">
		Hidden
	</div>

	<div  class="footer" >
		<br>&copy; 2018 Company, Inc. <br>
		Contact information: <a href="customerservice@momoneybank.com">customerservice@momoneybank.com</a>.<br>
	</div>
</body>
</html>