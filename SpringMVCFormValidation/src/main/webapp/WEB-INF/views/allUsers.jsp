<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>

<body>

    <h2>List of Users</h2>  
   <table class="table table-striped">
        <tr>
            <th>First Name</th><th>Last Name</th><th>DOB</th><th>Email</th><th>Edit</th><th>Delete</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
	            <td>${user.firstName}</td>
	            <td>${user.lastName}</td>
	            <td>${user.dob}</td>
	            <td>${user.email}</td>
	            <td><a href="<c:url value='/editUser/${user.id}'/>">Edit</a></td>
	            <td><a href="<c:url value='/deleteUser/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    
</body>
</html>