<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
<link rel="Stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<h2>Create</h2>
	
	<form class="form-group col-lg-6 col-md-6" action="CreateServlet" method="post">
	
		
		<label for="txtIdProduct" class="control-label">Id Product</label>
		<input type="text" id="txtIdProduct" name="txtIdProduct" class="form-control" value="id product generated automatically" disabled>
		
		<label for="txtNameProduct" class="control-label">Name Product</label>
		<input type="text" id="txtNameProduct" name="txtNameProduct" class="form-control" required>
		
		<label for="txtPriceProduct" class="control-label">Price product</label>
		<input type="text" id="txtPriceProduct" name="txtPriceProduct" class="form-control" >
		
		<br>
		<input type="submit" class="btn btn-success" value="Create">
		<a href="index.jsp" class="btn btn-danger">Cancel</a>
	</form>
	
	
	<script type="text/javascript" src="js/jQuery3.4.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>