<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />

	<h2>New Product Page</h2>
	<form action="admin?action=insertproduct" method="post">
		<div>
			<div>
				<label for="pname">Enter Product Name</label>
			</div>
			<div>
				<input type="text" id="pname" name="pname">
			</div>
		</div>
		<div>
			<div>
				<label for="pcost">Enter Product Cost</label>
			</div>
			<div>
				<input type="text" id="pcost" name="pcost">
			</div>
		</div>
		<div>
			<div>
				<label for="pdesc">Enter Product Description</label>
			</div>
			<div>
				<input type="text" id="pdesc" name="pdesc">
			</div>
		</div>
		<div>
			<div>
				<input type="submit" value="Submit">
			</div>
		</div>
	</form>

	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>