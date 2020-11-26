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
<script>
    /* The back() method loads the previous URL in the history list. 
       This is the same as clicking the "Back button" in your browser.
    */
    function goBack() {
        window.history.back()
    }
    </script>
</head>
<body>
<div class="w3-container w3-yellow">
<center>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
		<c:otherwise>
		<form action="${pageContext.request.contextPath}/admin/ordersummary" method="post">
	
           <a><b>Hello: "${user.name }"</b></a>
           <br> 
           <a><b>Email: "${user.email }"</b></a>
           <br>
           <a><b>Phone: "${user.phone }"</b></a>
           <br>
           <a><b>Delivery Address :"${user.address }" </b></a>
		
			<table border="1" cellspacing="5px" cellpadding="5px" class="w3-container w3-white" >
			
				<tr>
					<th type="checkbox" class="w3-container w3-teal">ID</th>
					<th class="w3-container w3-teal">Title</th>
					<th class="w3-container w3-teal">Unit</th>
					<th class="w3-container w3-teal">Cost Price</th>
				</tr>
				
				<c:forEach items="${items }" var="item">
					<tr>
					<td  >${item.id }</td>
					<td >${item.title }</td>
					<td >${item.unit }</td>
					<td >${item.price }</td>
					<td>
					</td>
				</tr>	
							
				</c:forEach>
				
			<tr>
                <td colspan="4">
                    <center>
                        <input type="submit" value="ConfirmOrder" class="w3-container w3-teal" />
                    </center>
                </td>
            </tr>
			</table>
		</form>
		</c:otherwise>
	</c:choose>

	
	<div class="w3-container w3-teal">
	 <a onclick="goBack()">Click here to modify the items list</a>
	 </div>
<hr />
<div class="w3-container w3-teal">
<a href="${pageContext.request.contextPath}/custom-login">Go Back To Home Page</a>
</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
	</center>
	</div>
</body>
</html>