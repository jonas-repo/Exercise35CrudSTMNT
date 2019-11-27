<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
<link rel="Stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<h2>Delete</h2>
	<form class="col-lg-6 col-md-5" action="Delete" method="post">
		<label class="control-label" for="txtId">ID from product</label>
		<input type="text" class="form-control" name="txtId" id="txtId" required>
		<br>
		<input type="submit" class="btn btn-danger" value="delete product">
	</form>

<script type="text/javascript" src="js/jQuery3.4.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>