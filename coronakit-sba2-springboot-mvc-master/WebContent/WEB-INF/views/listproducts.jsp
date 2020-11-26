<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
body {text-align: center;}
table {text-align: center;}
tr {text-align: center;}
td {text-align: center;}

</style>
<meta charset="ISO-8859-1">

<title>Items List</title> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<center>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="w3-container w3-teal">
	<h3> <b> ITEMS LIST </b></h3>
	</div>
	<div class="w3-container w3-yellow" >
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px" class="w3-container w3-white">
				<tr>
					<th class="w3-container w3-teal"> <b> ID </b></th>
					<th class="w3-container w3-teal"> <b> TITLE </b></th>
					<th class="w3-container w3-teal"><b> UNIT </b></th>
					<th class="w3-container w3-teal"><b> COST PRICE </b></th>
					<th class="w3-container w3-teal"><b> ACTION </b></th>
				</tr>
				<c:forEach items="${items }" var="item">
					<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>${item.unit }</td>
					<td>${item.price }</td>
					<td>
						<a href="deleteItem?icode=${item.id }">DELETE ITEM</a> <span>|</span>
						<a href="editItem?icode=${item.id }">EDIT ITEM</a> <span>|</span>
						
					</td>
				</tr>	
							
				</c:forEach>
			</table>
				
			<nav>
			<br>
			<a href="add-product" > <b> <button class="w3-container w3-teal"> Add New Product</button> </b>
			</a>
			</nav>
			
			
			
			
		</c:otherwise>
		
	</c:choose>
	
</div>
	<div class="w3-container w3-teal">
	<a href="${pageContext.request.contextPath}/custom-login" ><b> LOG OUT </b></a> </div>
	<br>
	<div class="w3-container w3-teal">
	<a href="${pageContext.request.contextPath}/custom-login"> <b> Go to Home Page </b></a> 
	</div>
	<br />
	</center>
</body>

</html>