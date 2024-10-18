<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>List of Family Allowances</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }

    h1 {
      color: #333;
      text-align: center;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin: 20px 0;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table, th, td {
      border: 1px solid #ddd;
    }

    th, td {
      padding: 10px;
      text-align: left;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    tr:hover {
      background-color: #ddd;
    }
  </style>
</head>

<body>


<c:if test="${not empty sessionScope.user && sessionScope.user.role == 'ADMIN'}">
  <div class="add-offer">
    <a href="AddAllowanceServlet" class="btn">Ajouter une Allowance</a>
  </div>
</c:if>
<h1>List of Family Allowances</h1>

<table>
  <thead>
  <tr>
    <th>Employee Name</th>
    <th>Children Count</th>
    <th>Allowance Amount</th>
    <th>Salary Amount</th>
    <th>Date Calculated</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="allowance" items="${familyAllowances}">
    <tr>
      <td>${allowance.employe.username}</td>
      <td>${allowance.childrenCount}</td>
      <td>${allowance.allowanceAmount}</td>
      <td>${allowance.salaryAmount}</td>
      <td>${allowance.dateCalculated}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
