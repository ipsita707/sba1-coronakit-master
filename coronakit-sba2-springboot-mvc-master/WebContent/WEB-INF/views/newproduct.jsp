<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Corona Kit-Add New Product(Admin)</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<center>
<div class="w3-container w3-yellow">
<body>


<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

<h3> <b> ${item.id==null?"ADD NEW ITEM":"Edit Item" } </b></h3>
	
	<form action='${item.id==null?"addItem":"saveItem" }' method="POST">
		<div>
			<label><b>ID: </b></label>
			<input type="number" value="${item.id }" name="icode" required 
			 ${item.id==null?"":"readonly" } />
		</div>
		<div>
			<label><b>Title: </b></label>
			<input type="text" value="${item.title }" name="title" minlength="3" maxlength="20" required />
		</div>
		<div>
			<label><b>Unit: </b></label>
			<input type="text" value="${item.unit }" name="unit" required />
		</div>
		<div>
			<label><b>Price: </b></label>
			<input type="decimal" value="${item.price }" name="price" required />
		</div>
	
		
		
		<a href="listproducts.jsp"><b><button class="w3-container w3-teal">SAVE ITEM</button></b></a>	
	</form>


<hr/>	
	<jsp:include page="footer.jsp"/>
	
</body>
</div>
</center>
</html>