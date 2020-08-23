<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
	<div>
		<table border="1">
			<c:forEach items="${products}" var="product">
				<tr>
					<td><c:out value="${product.id}" /></td>
					<td><c:out value="${product.productName}" /></td>
					<td><c:out value="${product.cost}" /></td>
					<td><c:out value="${product.productDescription}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>
	
	<hr/>
	<h2>Enter Product details to update</h2>
	<form action="admin?action=updateproduct" method="post">
		<div>
			<div>
				<label for="pid">Enter Product id</label>
			</div>
			<div>
				<input type="text" id="pid" name="pid">
			</div>
		</div>
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