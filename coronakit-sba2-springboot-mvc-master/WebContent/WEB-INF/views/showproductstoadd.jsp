<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>
<div class="w3-container w3-yellow">
<center> 
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
		<c:otherwise>
		<form action="placeorder" method="post">
			<table border="1" cellspacing="5px" cellpadding="5px" class="w3-container w3-white">
				<tr>
					<th type="checkbox" class="w3-container w3-teal">ID</th>
					<th class="w3-container w3-teal">Title</th>
					<th class="w3-container w3-teal">Unit</th>
					<th class="w3-container w3-teal">Cost Price</th>
					<th class="w3-container w3-teal">Action</th>
				</tr>
				<c:forEach items="${items }" var="item">
					<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>${item.unit }</td>
					<td>${item.price }</td>
					<td>
		        <input type = "checkbox" name="selection" value= "${item.id}"/>
					</td>
				</tr>	
							
				</c:forEach>
				
			<tr>
                <td colspan="4">
                    <center>
                        <input type="submit" value="PlaceOrder" class="w3-container w3-teal"/>
                    </center>
                </td>
            </tr>
			</table>
		</form>
		</c:otherwise>
	</c:choose>
	</center>
	</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>