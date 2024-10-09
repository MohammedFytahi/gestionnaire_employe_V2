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
        input, select {
            margin-bottom: 10px;
        }
        button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h1>Add New Employee</h1>
<form action="<c:url value='/addEmploye' />" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="EMPLOYE">Employé</option>
        <option value="ADMIN">Admin</option>
        <option value="RH">RH</option>
    </select>

    <label for="dateOfBirth">Date of Birth:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" required>

    <label for="socialNbr">Social Number:</label>
    <input type="text" id="socialNbr" name="socialNbr" required>

    <label for="dateOfJoining">Date of Joining:</label>
    <input type="date" id="dateOfJoining" name="dateOfJoining" required>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required>

    <label for="childNbr">Number of Children:</label>
    <input type="number" id="childNbr" name="childNbr" required>

    <label for="leaveBalance">Leave Balance:</label>
    <input type="number" id="leaveBalance" name="leaveBalance" required>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" required>

    <label for="post">Post:</label>
    <input type="text" id="post" name="post" required>

    <button type="submit">Add Employee</button>
</form>
</body>
</html>
