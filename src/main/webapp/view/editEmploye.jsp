<%--
  Created by IntelliJ IDEA.
  User: YCode
  Date: 09/10/2024
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body>
<h1>Edit Employee</h1>
<form action="<c:url value='/editEmploye' />" method="post">
    <input type="hidden" name="id" value="${employe.id}">

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${employe.username}" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${employe.email}" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${employe.password}" required>

    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="EMPLOYE" <c:if test="${employe.role == 'EMPLOYE'}">selected</c:if>>Employé</option>
        <option value="ADMIN" <c:if test="${employe.role == 'ADMIN'}">selected</c:if>>Admin</option>
        <option value="RH" <c:if test="${employe.role == 'RH'}">selected</c:if>>RH</option>
    </select>

    <label for="dateOfBirth">Date of Birth:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" value="${employe.dateOfBirth}" required>

    <label for="socialNbr">Social Number:</label>
    <input type="text" id="socialNbr" name="socialNbr" value="${employe.socialNbr}" required>

    <label for="dateOfJoining">Date of Joining:</label>
    <input type="date" id="dateOfJoining" name="dateOfJoining" value="${employe.dateOfJoining}" required>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" value="${employe.salary}" required>

    <label for="childNbr">Number of Children:</label>
    <input type="number" id="childNbr" name="childNbr" value="${employe.childNbr}" required>

    <label for="leaveBalance">Leave Balance:</label>
    <input type="number" id="leaveBalance" name="leaveBalance" value="${employe.leaveBalance}" required>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" value="${employe.department}" required>

    <label for="post">Post:</label>
    <input type="text" id="post" name="post" value="${employe.post}" required>

    <button type="submit">Update Employee</button>
</form>
</body>
</html>

