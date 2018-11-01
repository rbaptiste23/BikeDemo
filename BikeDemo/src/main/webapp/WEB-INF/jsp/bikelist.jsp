<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike Collection</title>

<link rel="stylesheet" type="text/css" href="css/bike.css">
</head>
<body>



	Customer List:
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Bike Information</th>

		</tr>

		<c:forEach var="clist" items="${customerlist}">
			<tr>


				<td><c:out value="${clist.name}" /></td>
				<td><c:out value="${clist.email}" /></td>
				<td><c:out value="${clist.phone}" /></td>
				<tr>
 				<c:forEach var="blist" items="${clist.bike}"> 
 				    <tr>
 				        <td></td><td></td><td></td> 
 						<td><c:out value="${blist.serialNumber}" /></td> 
 						<td><c:out value="${blist.purchasePrice}" /></td> 
 						<td><c:out value="${blist.purchaseDate}" /></td>
 						<td><c:out value="${blist.model}" /></td>
 				     </tr> 
 					</c:forEach> 
 				</tr>
 			</c:forEach> 
	</table>

	<form>
		<table class="formtable">
			<tr>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Welcome">Main Menu</Button></td>
			</tr>
		</table>
	</form>


	<%-- 	<form:form modelAttribute="bikelist"> 
	
	
	</form:form> --%>

</body>
</html>