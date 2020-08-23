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
			<tr>
				<td>Kit Id</td>
				<td>Product Id</td>
				<td>Quantity</td>
				<td>Amount</td>
			</tr>
			<c:forEach items="${kits}" var="kit">
				<tr>
					<td><c:out value="${kit.id}" /></td>
					<td><c:out value="${kit.productId}" /></td>
					<td><c:out value="${kit.quantity}" /></td>
					<td><c:out value="${kit.amount}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<hr/>
	<h2>Delete Product</h2>
	<form action="user?action=deleteproduct" method="post">
		<div>
			<div>
				<label for="pid">Enter Product Id</label>
			</div>
			<div>
				<input type="text" id="pid" name="pid">
			</div>
		</div>
		
		<div>
			<div>
				<input type="submit" value="Delete">
			</div>
		</div>
	</form>
	<hr />
	<div>
		<a href="user?action=addnewitem"><button>Product Page</button></a>
	</div>
	<hr/>
	<jsp:include page="footer.jsp" />
</body>
</html>