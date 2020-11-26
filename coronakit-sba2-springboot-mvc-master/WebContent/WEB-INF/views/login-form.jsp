<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

form {text-align: center;}
h2 {text-align: center;}
h3 {text-align: center;}
</style>
<meta charset="ISO-8859-1">

<title> Welcome To Corona Prevention Kit - Home </title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<div class="w3-container w3-teal">
<body>

<jsp:include page="header.jsp"/>

<hr/>
	 <h2> <b> ADMIN LOGIN </b></h2> 
	
	<form action="${pageContext.request.contextPath}/admin/list" method="get" modelAttribute="form">
		<div class="w3-container w3-yellow">
			<div><label for="loginid"> <b>Enter Login ID </b></label> </div>
			<div><input type="text" id="uName" name="uName"> </div>
		</div>
		<div class="w3-container w3-yellow">
			<div><label for="password"> <b> Enter Password </b></label> </div>
			<div><input type="password" id="pwd" name="pwd"> </div>
		</div>
		<div class="w3-container w3-yellow">
		<br>
			<div><input type="submit" value="Login" class="w3-container w3-teal"> </div>
			<br>
		</div>
	</form>
	

<hr/>

<div class="w3-container w3-teal">
	<%-- <a href="user?action=list" method=""><button>Create Corona Kit</button></a> --%>
	 <h3><a href="${pageContext.request.contextPath}/admin/new-user"> <b>CLICK HERE TO PROCEED AS A "NEW USER" </b> </a> </h3>
</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</div>
</html>