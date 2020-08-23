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
				<td>Product Id</td>
				<td>Name</td>
				<td>Cost</td>
				<td>Description</td>
			</tr>
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

	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>