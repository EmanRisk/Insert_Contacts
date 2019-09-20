<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.contacts.beans.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%-- <% ArrayList<Contact> contacts = (ArrayList<Contact>)request.getAttribute("meow");--%>

<table border="1">

<tr>
<th>Name</th>
<th>Phone Number</th>
<th>Address</th>
<th>email</th>
</tr>

<c:forEach var="m" items="${meow}">
<tr>
<td>${m.name}</td>
<td>${m.address}</td>
<td>${m.email}</td>
<td>${m.phoneNumber}</td>
</tr>
</c:forEach>
</table>

<%-- 
<% for(int i = 0; i < contacts.size(); i++) { %> <!-- add = when outputting information -->
<tr>
<td><%= contacts.get(i).getName() %></td>
<td><%= contacts.get(i).getPhoneNumber() %></td>
<td><%= contacts.get(i).getAddress() %></td>
<td><%= contacts.get(i).getEmail() %></td>
</tr>
<% } %>
--%>


<a href="NewContacts.html">Add Contact</a>

</body>
</html>