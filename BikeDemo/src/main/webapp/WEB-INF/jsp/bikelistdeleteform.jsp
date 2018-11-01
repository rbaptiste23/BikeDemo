<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike Form</title>

<!--  <link rel="stylesheet" type="text/css" href="css/bike.css"> -->

<style type="text/css">
.formtable {
	background-color: orange;
	font-size: 20px;
	color: white;
}

body {
	background-color: orange;
}
</style>
</head>
<body>

	<form action="http://localhost:8080/Delete/${id}" method="POST">
		<table class="formtable">

			<tr>
				<td>Bike Id:</td>
				<td><input type="text" name="id" value=""></td>
			</tr>

		   <tr> 			
				<td><Button type="submit" name="blist">Delete Bike</Button></td>
			</tr>

		</table>

	</form>

	<br />
	<br />
	<form>
		<table class="formtable">

			<tr>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Welcome">Main Menu</Button></td>

			</tr>


		</table>
	</form>

</body>
</html>