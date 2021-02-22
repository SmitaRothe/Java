<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Management Home</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div align="center">
    <h2>Book List</h2>
    
    <table border="1" cellpadding="10">
    	<tr>
    		<th>No</th>
    		<th>Book Id</th>
    		<th>Author</th>
    		<th>Publisher</th>
    		<th>Publish Date</th>
    		<th>Action</th>
    	</tr>
    	<c:forEach items="${listBook}" var="book" varStatus="status">
    		<tr>
    			<td>${status.index+1}</td>
    			<td>${book.bookId}</td>
    			<td>${book.author}</td>
    			<td>${book.publisher}</td>
    			<td>${book.publish_date}</td>
    			<td>
    			  <a href="edit?id=${book.bookId}">Edit</a>
    			  <a href="delete?id=${book.bookId}">Delete</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    <h3><a href="newBook">Add New Book</a></h3>
</div>
<br>
<br>
<jsp:include page="footer.jsp" ></jsp:include>	
</body>
</html>