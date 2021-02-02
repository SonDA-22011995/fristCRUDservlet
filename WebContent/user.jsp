<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Update User</h1>
    <p>NOTE: You can't update the email address.</p>
    <form action="check" method="post">
        <input type="hidden" name="action" value="update_user">
        <input type="hidden" name="email" value="${user.getEmail()}">        
        <label class="pad_top">Email:</label>
        <input type="email"  value="${user.getEmail()}" 
               disabled><br>
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${user.getFristName()}" 
               required><br>
        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${user.getLastName()}"  
               required><br>        
        <label>&nbsp;</label>
        <input type="submit" value="Update" class="margin_left">
    </form>
</body>
</html>