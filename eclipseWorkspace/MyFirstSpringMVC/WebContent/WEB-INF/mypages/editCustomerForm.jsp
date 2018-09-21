<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fork" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light text-center">
 	<a class="navbar-brand" href="welcome">Home</a>
</nav>
	<fork:form action="../saveEditCustomer" method="post">
		ID : <fork:input path="custId" readonly="true"/>
		Name : <fork:input path="custName" readonly="true"/>
		Phone : <fork:input path="custPhone"/>
		City : <fork:input path="custCity"/>
		Active? : <fork:input path="isActive" readonly="true"/>
		<input type="submit" value=" S A V E ">
	</fork:form>

</body>
</html>