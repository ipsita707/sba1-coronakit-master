<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>
<center>
		<h2 class="w3-container w3-teal">Please Enter Below Details</h2>
	<form action="showList" method="POST">
		<div class="w3-container w3-yellow">
			<div><label for="name">ENTER NAME</label> </div>
			<div><input type="text" name="name"> </div>
		</div>
		 <div class="w3-container w3-yellow">
			<div><label for="email">ENTER EMAIL</label> </div>
			<div><input type="text" name="email"> </div>
		</div>
		<div class="w3-container w3-yellow">
			<div><label for="address">ENTER ADDRESS</label> </div>
			<div><input type="text" name="address"> </div>
		</div>
		<div class="w3-container w3-yellow">
			<div><label for="phone">ENTER PHONE</label> </div>
			<div><input type="number" name="phone"> </div>
		</div>
			<br>
			<div><b><input type="submit" value="Save" class="w3-container w3-teal"></b></div>
			<br>
		
	</form>
	</center>
	

	<jsp:include page="footer.jsp"/>
</body>
</html>