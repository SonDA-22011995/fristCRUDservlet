<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Insert User</h1>
    <form action="check" method="post">
        <input type="hidden" name="action" value="insert_user">       
        <label class="pad_top">Email:</label>
        <input type="email"  name="email" required><br>
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" required><br>
        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" required><br>        
        <label>&nbsp;</label>
        <input type="submit" value="Insert" class="margin_left">
    </form>
</body>
</html>