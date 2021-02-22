<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New/Edit Book</title>
	</head>
	
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div align="center">
			<h1>New Book/Update</h1>
			<form:form action="save" method="post" modelAttribute="book">
				<table cellpadding="10">
					<form:hidden path="bookId" />
					
					<tr>
						<td>Author:</td>
						<td><form:input path="author" /></td>
					</tr>
					<tr>
						<td>Publisher:</td>
						<td><form:input path="publisher" /></td>
					</tr>
					<tr>
						<td>Publish Date:</td>
						<td><form:input path="publish_date" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>