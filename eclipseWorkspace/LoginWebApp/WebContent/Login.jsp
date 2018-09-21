<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%@ include file="Login.html" %>

<jsp:useBean id="login" class="pkg.LoginCheck" scope="session"/>

<jsp:setProperty property="*" name="login"/>

<%
	try{
	if(login.isValidLoginNew())
		out.println("User Login Success . . .");
	else
		out.println("User Login Failed . . .");
	}
	catch(Exception e){}
%>

<%--

	<font color="red">------HELLO</font>
	<br>
	<%= 2 + 4 %>
	
	<%
		int a = 2 + 4;
		out.println(a);
	%>
	
 --%>
 
 
 

	