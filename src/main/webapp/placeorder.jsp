<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Place Order(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<h2>Place Order</h2>
	<form action="user?action=ordersummary" method="post">
		<div>
			<div>
				<label for="add">Enter Address</label>
			</div>
			<div>
				<input type="text" id="add" name="add">
			</div>
		</div>
		
		<div>
			<div>
				<input type="submit" value="Order">
			</div>
		</div>
	</form>


	<hr />	
	<jsp:include page="footer.jsp"/>
</body>
</html>