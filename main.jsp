<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.user.Customer" %>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<% Customer customer = (Customer) session.getAttribute("customer"); %>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>MO Money Bank Main</title>
	<link rel="stylesheet" type="text/css" href="./styles/styles.css"> 

 	
	
	
	</head>
	<body>
		<div class="header">
			<form action="LogOutServlet" method="post" ><a href="index.jsp"><img src="BankLogo1.jpg" height="40" width="150" class="main headerpic"></a></form> 
			<div class="mainabout"><a href="Aboutus.jsp">About Us</a></div>
			<div class="mainlocation"><a href="Location.jsp">Location</a></div>
			<div class="signout"><form action="LogOutServlet" method="post" ><a href="index.jsp">Log Out</a></form></div>
		 </div>
		<h2>Welcome To M.O. Money Bank</h2>

		<div>
			<h2>Hello, <% out.print(customer.getFirstName()); %></h2>
		</div>
		
		<!-- left Menu -->
		<div class="leftmain">
			<!--  Balance -->
			<div>
				<h3>Balance:
				<%out.print(customer.getTransaction().getBalance()); %></h3>
			</div> <br>
			
			<!-- View all transactions  -->
			<div >
					<h3><a href="TransactionServlet" >View All Transactions</a></h3>
			</div> <br>
		
		
			<!-- View numbers of transactions -->
			<div>
				<h3>View numbers of transaction:</h3> 
					<form action="ViewNumbersOfTransactionServelet" method="post">
  						<input type="number" name="viewNumber" min="1" max="10" />
  						<input type="submit" value="View" id="button" />
					</form>  
			</div> <br>
				
			<!-- Delete Account -->
			<div>
				<form action="DeleteAccountServlet" method="post" >
					<h3><a href="index.jsp">Delete Account</a></h3>
				</form>
			</div>
		</div>
		
		<!-- Right Menu -->
		<div class="rightmain">
			<!-- Deposit -->
			<div>
				<h3>Deposit</h3>
				<form action="DepositServlet" method="post">
					<div>
						<input type="text" class="form-control" name="deposit" id="deposit" placeholder="Deposit Amount">
					</div>
					<input type="submit" id="button">	
				</form>
			</div>
			
			<!-- Withdrawal -->
			<div>
				<h3>Withdraw</h3>
				<form action="WithdrawalServlet" method="post">
					<div>
						<input type="text" class="form-control" name="withdrawal" id="withdrawal" placeholder= "Withdrawal Amount">
					</div>
					<input type="submit" id="button">
				</form>
			</div> <br>
			
			<!-- Transfer Fund -->
			<div >
				<form action="TransferFundServlet" method="post" class="wire" >
  					Transfer Money:<br> 
  					Email:<input type="text" name="email" placeholder="email"><br>
  					Amount $: <input type="text" name="amount" placeholder="amount" > <br>
  					<input type="submit" value="Submit" id="button">
				</form> 
			</div> <br>
			
			<!-- Order Checkbook -->
			<div>
				<a onclick="alert('Checkbook has been ordered')" >Order Checkbook</a>	
			</div>
			
		</div>
		
		<!-- Finance Image -->
		<div class="finance">
			<img src="finance.jpeg" height="90" width="565" class="main">
		</div>
		<div class="investment">
			<img src="investment.jpg" height="90" width="565" class="main">
		</div>
		<div class="loan">
			<img src="loan.jpg" height="90" width="565" class="main">
		</div>
		<div class="saving">
			<img src="saving.jpg" height="90" width="565" class="main">
		</div>
		
		<div class="financeword">
			Need To Refinance?
		</div>
		
		<div class="investword">
			Need An Investment?
		</div>
		
		<div class="loanword">
			Need A Loan?
		</div>
		
		<div class="savingword">
			Need A Saving Account?
		</div>
		
		<div class="response">
			M.O. Money Bank Got It For You!
		</div>
		
		
		
	<div  class="footer" >
					<br>&copy; 2018 Company, Inc. <br>
					Contact information: <a href="customerservice@momoneybank.com">customerservice@momoneybank.com</a>.<br>
				</div>  
	
	</body>
</html>