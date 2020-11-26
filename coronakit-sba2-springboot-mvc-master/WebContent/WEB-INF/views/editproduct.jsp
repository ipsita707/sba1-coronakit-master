<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> <b>CORONA KIT - EDIT PRODUCT(ADMIN)</b></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-teal">
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

<h3>${item.icode==null?"New Item":"Edit Item" }</h3>
	
	<form action='${item.icode==null?"addItem":"saveItem" }' method="POST">
		<div>
			<label><b>ICODE:</b> </label>
			<input type="number" value="${item.icode }" name="icode" required 
			 ${item.icode==null?"":"readonly" } />
		</div>
		<div>
			<label><b>TITLE:</b> </label>
			<input type="text" value="${item.title }" name="title" minlength="3" maxlength="20" required />
		</div>
		<div>
			<label><b>UNIT: </b></label>
			<input type="text" value="${item.unit }" name="unit" required />
		</div>
		
		<button><b>SAVE</b></button>		
	</form>





<hr/>	
	<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>