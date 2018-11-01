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

	<form action="http://localhost:8080/Save/${id}" method="POST">
		<table class="formtable">

			<tr>
				<td>id:</td>
				<td><input type="text" name="id" value=""></td>
			</tr>

			<tr>
				<td>Contact:</td>
				<td><input type="text" name="contact" value="true"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="test@tt.com">
				</td>
			</tr>

			<tr>
				<td>Model:</td>
				<td><input type="text" name="model" value="XM200"></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="John Doe"></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="405-424-4487"></td>
			</tr>

			<tr>
				<td>Purchase Date:</td>
				<td><input type="text" name="purchaseDate"></td>
			</tr>

			<tr>
				<td>Purchase Price:</td>
				<td><input type="text" name="purchasePrice" value="154.26"></td>
			</tr>

			<tr>
				<td>Serial Number:</td>
				<td><input type="text" name="serialNumber" value="SN14545451"></td>
			</tr>

			<tr>
			<!--  
				
				<td><Button type="submit" name="blist" formmethod="post"
						formaction="http://localhost:8080/Save/${id}">Update Bike</Button></td>
						
					-->	
							
				<td><Button type="submit" name="blist"> Update Bike</Button></td>
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