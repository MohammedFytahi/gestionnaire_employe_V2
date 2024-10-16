<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .form-container {
            max-width: 600px; /* Set max width */
            margin: 0 auto; /* Center the form */
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input, select {
            width: 100%; /* Full width */
            padding: 10px; /* Add padding */
            margin-bottom: 15px; /* Space below */
            border: 1px solid #ccc; /* Border style */
            border-radius: 4px; /* Rounded corners */
            box-sizing: border-box; /* Include padding in width */
        }

        button {
            background-color: #007BFF; /* Blue background */
            color: white; /* White text */
            padding: 10px; /* Padding */
            border: none; /* No border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size */
            transition: background-color 0.3s; /* Smooth transition */
            width: 100%; /* Full width */
        }

        button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Add New Employee</h1>
<div class="form-container">
    <form action="<c:url value='/addEmploye' />" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

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
</div>
</body>
</html>
