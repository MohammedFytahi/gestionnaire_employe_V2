<%--
  Created by IntelliJ IDEA.
  User: Fytahi
  Date: 09/10/2024
  Time: 14:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>List of Employees</title>
  <style>
    body {
      font-family: Arial, sans-serif; /* Change the font */
      background-color: #f4f4f4; /* Light background color */
      margin: 0; /* Remove default margin */
      padding: 20px; /* Add some padding */
    }

    h1 {
      text-align: center; /* Center align the heading */
      color: #333; /* Darker color for the heading */
    }

    table {
      width: 100%; /* Full width */
      border-collapse: collapse; /* Merge borders */
      margin: 20px 0; /* Add margin */
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Shadow effect */
    }

    thead {
      background-color: #007BFF; /* Blue background for header */
      color: white; /* White text */
    }

    th, td {
      padding: 12px; /* Padding for cells */
      text-align: left; /* Left align text */
      border-bottom: 1px solid #ddd; /* Bottom border for rows */
    }

    tr:hover {
      background-color: #f1f1f1; /* Highlight row on hover */
    }

    a {
      text-decoration: none; /* Remove underline */
      color: #007BFF; /* Link color */
    }

    a:hover {
      text-decoration: underline; /* Underline on hover */
    }

    .action-links {
      display: flex; /* Flexbox for action links */
      gap: 10px; /* Space between links */
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>List of Employees</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Role</th>
    <th>Date of Birth</th>
    <th>Date of Joining</th>
    <th>Salary</th>
    <th>Department</th>
    <th>Post</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="employe" items="${employes}">
    <tr>
      <td>${employe.id}</td>
      <td>${employe.username}</td>
      <td>${employe.email}</td>
      <td>${employe.role}</td>
      <td>${employe.dateOfBirth}</td>
      <td>${employe.dateOfJoining}</td>
      <td>${employe.salary}</td>
      <td>${employe.department}</td>
      <td>${employe.post}</td>
      <td class="action-links">
        <a href="editEmploye?id=${employe.id}">Edit</a>
        <a href="deleteEmploye?id=${employe.id}" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
