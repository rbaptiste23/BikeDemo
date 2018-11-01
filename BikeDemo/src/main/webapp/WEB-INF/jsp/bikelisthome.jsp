<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="search" value="/Search" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike Collection</title>

<link rel="stylesheet" type="text/css" href="css/bike.css">
</head>
<body>

	<H1>
		<B>Welcome to Bike list </B>
	</H1>
	<br />
	<br />
	<br />

	<form>
		<table class="formtable">
			<tr>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Display">Display Bike</Button></td>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Display/Page">Display
						Paging Bike</Button></td>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Create">Create Bike</Button></td>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Save">Update Bike</Button></td>
				<td><Button type="submit" name="blist" formmethod="get"
						formaction="http://localhost:8080/Delete">Delete Bike</Button></td>

			</tr>
		</table>
	</form>

	<br />
	<br />
	<div class="row">
		<div class="col-md-8 col-md-offset-2">

			<form action="${search}" method="post">

				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />

				<div class="input-group input-group-lg">
					<input type="text" class="form-control" name="s"
						placeHolder="Search Hobbies"> <span
						class="input-group-btn">
						<button id="search-button" class="btn_btn-primary" type="submit">
							Find People</button>

					</span>

				</div>



			</form>

		</div>
	</div>

</body>
</html>