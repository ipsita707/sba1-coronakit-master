<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<hr />
	<div>
		<a href="admin?action=newproduct"><button>New Products</button></a>
	</div>
	<hr />
	<div>
		<a href="admin?action=editproduct"><button>Edit Products</button></a>
	</div>
	<hr />
	<div>
		<a href="admin?action=list"><button>List Products</button></a>
	</div>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>