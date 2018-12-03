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
<title>View All Transactions</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css"> 


</head>
<body >

	<div class="header">
			<form action="LogOutServlet" method="post" ><a href="index.jsp"><img src="BankLogo1.jpg" height="40" width="150" class="main headerpic"></a></form> 
			<div class="mainabout"><a href="Aboutus.jsp">About Us</a></div>
			<div class="mainlocation"><a href="Location.jsp">Location</a></div>
			<div class="signout"><form action="LogOutServlet" method="post" ><a href="index.jsp">Log Out</a></form></div>
			<div class="home"><form action="HomeServlet" method="post" ><a href="main.jsp">Home</a></form></div>		 
		 </div>
	<div>
		<h2 align="center">All Transactions</h2>
	</div>
	
	<div align="center"> <br>
		<table class="trantable" >
			<thead>
				<tr>
					<th>Date</th>
					<th>Time</th>
					<th>Action</th>
					<th>Balance</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${transaction}" var="tran"> 
					<c:set var = "separatedValue" value = "${fn:split(tran, ' ')}" />
     					<tr>
        					<td><c:out value="${separatedValue[0]}" /></td>
        					<td><c:out value="${separatedValue[1]}" /></td>
        					<td><c:out value="${separatedValue[2]}" /></td>
        					<td><c:out value="${separatedValue[3]}" /></td>
      					</tr>
      				
    			</c:forEach>
			</tbody>
		</table>
	</div>	<br><br>
	<!-- Left logo -->
	<div>
		<img src="BankLogo1.jpg" height="270" width="270" class="sidelogo leftlogo">
	</div>
	
	<!-- Right logo -->
	<div>
		<img src="BankLogo1.jpg" height="270" width="270" class="sidelogo rightlogo">
	</div> 
	
	
	<div  class="footer" >
					<br>&copy; 2018 Company, Inc. <br>
					Contact information: <a href="customerservice@momoneybank.com">customerservice@momoneybank.com</a>.<br>
				</div> 

	
	
</body>
</html>