<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
</head>
 <!-- 2 way to access static resource in jsp
 ${pageContext.request.contextPath}/styles/main.css
 <c:url value='/styles/main.css'/>
  -->

<body>

<h1>Users</h1>
<p>${message}</p>
<table>

  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th colspan="3">Email</th>
  </tr>
  <c:forEach var="user" items="${users.getUsers()}">
	 <tr>
	   <td><c:out value="${user.getFristName()}"/></td>
	   <td><c:out value="${user.getLastName()}"/></td>
	   <td><c:out value="${user.getEmail()}"/></td>
	   <td><a href="check?action=select_user_update&amp;email=<c:out value="${user.getEmail()}"/>">Update</a></td>
	   <td><a href="check?action=delete_user&amp;email=<c:out value="${user.getEmail()}"/>">Delete</a></td>
	 </tr>
 	</c:forEach>
</table>


<p><a href="userAdmin">Refresh</a></p>
<p><a href="<c:url value='/insert'/>">Insert User</a></p>

</body>
</html>