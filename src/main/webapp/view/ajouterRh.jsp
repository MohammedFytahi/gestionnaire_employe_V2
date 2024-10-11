<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add New Employee</title>
  <style>
    label {
      display: block;
      margin-top: 10px;
    }
    input {
      margin-bottom: 10px;
    }
    button {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<h1>Add New RH</h1>
<form action="<c:url value='/AddRhServlet' />" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required>

  <button type="submit">Add RH</button>
</form>
</body>
</html>
