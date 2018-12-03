<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>M.O. MONEY BANK</title>
		<link rel="stylesheet" type="text/css" href="./styles/styles.css"> 
	</head>
	
		

	<body color=#009051>
		
		<div class="header">
			<form action="LogOutServlet" method="post" ><a href="index.jsp"><img src="BankLogo1.jpg" height="40" width="150" class="main headerpic"></a></form> 
			<div class="aboutus"><a href="Aboutus.jsp">About Us</a></div>
			<div class="location"><a href="Location.jsp">Location</a></div>
		 </div>
		<br><br><br>
		
		<div>
			<img src="mainPic.jpg" id="mainPIC" width="1265" height="400" class="main">
		</div>
		
		<form id="mainForm" action="SignInServlet" method="post">

  			<div class="form-group">
    			<label for="loginID" x>Personal ID:</label>
    			<input type="email" class="form-control" id="mainInput" aria-describedby="emailHelp" name="email" placeholder="Enter email">
  			</div> <br>

  			<div class="form-group">
    			<label for="exampleInputPassword1">Password:</label>
    			<input type="password" class="form-control" id="mainInput" name="password" placeholder="Password">
  			</div>
	
  			

  			<button type="submit" class="btn btn-primary" id="button">Submit</button>
		</form>
		<p ><a href="registration.jsp" class="newuser">New user? Set online access</a></p>
		<br>
	
			
				<div  class="footer" >
					<br>&copy; 2018 Company, Inc. <br>
					Contact information: <a href="customerservice@momoneybank.com">customerservice@momoneybank.com</a>.<br>
				</div>
				 
			
		
	</body>
</html>