<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



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

.error {
  font-size: small;
  color: red;
  margin-left: 10px; 

}
</style>
</head>
<body>

	<sf:form modelAttribute="bike">
		<table class="formtable">

	 

			<tr>
				<td>Contact:</td>
				<td><sf:input type="text" path = "contact" name="contact" value="true" /><br/><sf:errors path="contact" cssClass="error"></sf:errors></td>								
			</tr>

			<tr>
				<td>Email:</td>
				<td><sf:input type="text" path="email" name="email"  /><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Model:</td>
				<td><sf:input type="text" path="model" name="model"  /><br/><sf:errors path="model" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><sf:input type="text" path ="name" name="name" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><sf:input type="text" path="phone" name="phone" /><br/><sf:errors path="phone" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Purchase Date:</td>
				<td><sf:input type="text" path="purchaseDate" name="purchaseDate" /><br/><sf:errors path="purchaseDate" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Purchase Price:</td>
				<td><sf:input type="text" path="purchasePrice" name="purchasePrice"  /><br/><sf:errors path="purchasePrice" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Serial Number:</td>
				<td><sf:input type="text" path="serialNumber" name="serialNumber" /><br/><sf:errors path="serialNumber" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td><Button type="submit" name="blist" formmethod="post"
						formaction="http://localhost:8080/Create">Create Bike</Button></td>
			</tr>

		</table>

	</sf:form>

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