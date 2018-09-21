<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<nav class="navbar navbar-light bg-light text-center">
 	<a class="navbar-brand" href="welcome">Home</a>
</nav>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="well well-lg text-center">LIST OF ALL ACTIVE CUSTOMERS</div>
<table class="table">
<tr>
	<th>Customer ID</th>
	<th>Customer Name</th>
	<th>Customer Phone</th>
	<th>Customer City</th>
	<th>Customer Activity</th>
	<th>Edit Customer</th>
	<th>Delete Customer</th>
</tr>
<c:forEach var="cust" items="${allcust}">
	<tr>
   		<td>${cust.custId}</td>
   		<td>${cust.custName}</td>
   		<td>${cust.custPhone}</td>
   		<td>${cust.custCity}</td>
   		<td>${cust.isActive}</td>
   		<td><a href="editCustomer/${cust.custId}">Edit</a></td>
   		<td><a href="deleteCustomer/${cust.custId}">Delete</a></td>
	</tr>
</c:forEach>

</table>
</div>

	<br><br><br>
	<div class="text-right">
		<p><a class="btn btn-primary btn-lg" href="newCustomer" role="button">Add New Customer</a></p>
	</div>





	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>