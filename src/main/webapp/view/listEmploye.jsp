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
</head>
<body>
<h1>List of Employees</h1>
<table border="1">
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
      <td>
        <a href="editEmploye?id=${employe.id}">Edit</a>
        <a href="deleteEmploye?id=${employe.id}" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
