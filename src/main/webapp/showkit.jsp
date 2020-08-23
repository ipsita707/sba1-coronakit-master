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
	<div>
		<a href="user?action=deleteitem"><button>Update Cart</button></a>
	</div>
	
	<div>
		<a href="user?action=placeorder"><button>Checkout</button></a>
	</div>
	
	<div>
		<a href="user?action=addnewitem"><button>Product Page</button></a>
	</div>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>