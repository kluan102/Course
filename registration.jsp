<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MO Money Bank</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">

</head>
<body>
	<div class="header">
			<form action="LogOutServlet" method="post" ><a href="index.jsp"><img src="BankLogo1.jpg" height="40" width="150" class="main headerpic"></a></form> 
			<div class="aboutus"><a href="Aboutus.jsp">About Us</a></div>
			<div class="location">Location</div>
		 </div>
		
		
		
		<h2>Enroll in Online and Mobile Banking</h2> <br><br>
	
		<div class="main happyfamily">
			<img src="HappyFamily.jpg" height="220" width="420" >
		</div>
		<div class="main nicehouse">
			<img src="Nicehouse.jpg" height="220" width="420" >
		</div>
		
		<div class="main nicecar">
			<img src="Nicecar.jpg" height="220" width="450" >
		</div>
		
		<div class="main retirement">
			<img src="Retirement.jpg" height="220" width="450" >
		</div>


<form id="signup" action="RegistrationServlet" method="post" >
	<div class="form-group">
    	<label for="firstName"> First Name </label>
    	<input type="text" class="form-control" name="firstName" id="firstName" placeholder="First Name">
  	</div>
  	<div class="form-group">
    	<label for="lastName">Last Name</label>
    	<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last Name">
  	</div>
  	<div class="form-group">
    	<label for="email">Email address</label>
    	<input type="text" class="form-control" name="email" id="email" placeholder="Email"><br>
  	</div>
 	<div class="form-group">
    	<label for="phoneNumber">Phone number</label>
    	<input type="text" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="Phone Number">
  	</div>
  	<div class="form-group">
    	<label for="password">Password</label>
    	<input type="password" class="form-control" name="password" id="password" placeholder="Password">
  	</div>
   	<div class="form-group">
    	<label for="street">Street</label>
    	<input type="text" class="form-control" name="street" id="street" placeholder="Street">
  	</div>
   	<div class="form-group">
    	<label for="city">City</label>
    	<input type="text" class="form-control" name="city" id="city" placeholder="City">
  	</div>
   	<div class="form-group">
    	<label for="state">State</label>
    	<input type="text" class="form-control" name="state" id="state" placeholder="State"> <br>
  	</div>
 	<div class="form-group">
    	<label for="zipCode">Zip Code</label>
    	<input type="text" class="form-control" name="zipcode" id="zipCode" placeholder="Zip Code">
  	</div>

  	<div class="form-group">
    	<label for="initialDeposit">Initial Deposit</label>
    	<input type="text" class="form-control" name="initialDeposit" id="initialDeposit" placeholder="Initial Deposit">
  	</div>
  	<input type="submit" class="btn btn-default"/>
</form>

<br>
	
			
				<div  class="footer" >
					<br>&copy; 2018 Company, Inc. <br>
					Contact information: <a href="customerservice@momoneybank.com">customerservice@momoneybank.com</a>.<br>
				</div>
				 
			
</body>
</html>