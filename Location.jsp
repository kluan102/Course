<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location</title>
</head>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<body>
	<div class="header">
			<form action="LogOutServlet" method="post" ><a href="index.jsp"><img src="BankLogo1.jpg" height="40" width="150" class="main headerpic"></a></form> 
			<div class="aboutus"><a href="Aboutus.jsp">About Us</a></div>
			<div class="location"><a href="Location.jsp">Location</a></div>
	</div>
		<br><br><br>
	
	<div class="locationsection">
		<img src="claim.jpg" height="280" width="430" class="claim">
		<div>
			<img src="map.png" height="600" width="823" class="map">
		</div>
		<div class="headaddress">
			<div style="font-size: 43px; color:#009051 ">Headquarter Location</div> <br>
			<div style="font-size: 30px; color:#45462A">2119 Olive St <br>
			Saint Louis, MO, 63108 <br>
			314.499.5888 
			</div>
			
			
		</div>
	</div>	
	
	<div style="position: absolute; top: 115%; color: black;">
		Hidden
	</div>
	<div  class="footer" >
		<br>&copy; 2018 Company, Inc. <br>
		Contact information: <a href="customerservice@momoneybank.com">customerservice@momoneybank.com</a>.<br>
	</div>	
		

</body>
</html>