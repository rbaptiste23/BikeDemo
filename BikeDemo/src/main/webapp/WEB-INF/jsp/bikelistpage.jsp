<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="url" value="/Display/Page" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike Collection</title>

<style type="text/css">
.formtable {
	background-color: orange;
	font-size: 20px;
	color: white;
}

body {
	background-color: orange;
}

table, th, td {
	border: 1px solid black;
	text-align: left;
}

.pagination {
  margin-top: 20px;
  margin-bottom:40px;

}

</style>
</head>
<body>

<div class="pagination">

 <c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
 
   <c:choose> 
     <c:when test ="${page.number != pageNumber-1}"> 
      <a href="${url}?p=${pageNumber}" ><c:out value ="${pageNumber}" /></a>
     
     </c:when>
     
     <c:otherwise>
       <strong><c:out value="${pageNumber}" /></strong>
     
      </c:otherwise>     
   
   </c:choose>

  <c:if  test="${pageNumber != page.totalPages}" >
     | 
   </c:if>
 </c:forEach>
 
</div>

Bike List:
	<table class="formtable">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Model</th>
			<th>Purchase Date</th>
		</tr>
		<c:forEach var="bike" items="${page.content}">
			<tr>
				<td><c:out value="${bike.id}" /></td>
				<td><c:out value="${bike.name}" /></td>
				<td><c:out value="${bike.email}" /></td>
				<td><c:out value="${bike.phone}" /></td>
				<td><c:out value="${bike.model}" /></td>
				<td><c:out value="${bike.purchaseDate}" /></td>
			</tr>
		</c:forEach>
	</table>

	 <form>
	  <table class="formtable">
	    
	     <tr>
		 <td><Button type="submit" name="blist" formmethod="get" formaction="http://localhost:8080/Welcome">Main Menu</Button></td>
		 
		</tr>
		
		
		</table>
		</form>


</body>
</html>