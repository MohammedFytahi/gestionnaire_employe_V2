<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Demandes de Congé</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }

    h2 {
      color: #333;
      text-align: center;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin: 20px 0;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border: 1px solid #ddd;
      background-color: #fff;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f9f9f9;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    form {
      display: inline;
    }

    button {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 8px 12px;
      cursor: pointer;
      margin: 0 5px;
      transition: background-color 0.3s;
    }

    button:hover {
      background-color: #45a049;
    }

    .container {
      max-width: 1200px;
      margin: auto;
      padding: 20px;

      border-radius: 8px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">

  <h2>Demandes de Congé</h2>
  <table>
    <tr>
      <th>ID</th>
      <th>ID Employé</th>
      <th>Date de Début</th>
      <th>Date de Fin</th>
      <th>Motif</th>
      <th>Statut</th>
      <th>Actions</th>
    </tr>
    <c:forEach var="request" items="${leaveRequests}">
      <tr>
        <td>${request.leaveRequestId}</td>
        <td>${request.employeeId}</td>
        <td>${request.startDate}</td>
        <td>${request.endDate}</td>
        <td>${request.leaveReason}</td>
        <td>${request.status}</td>
        <td>
          <form action="${pageContext.request.contextPath}/updateLeaveRequestStatus" method="post">
            <input type="hidden" name="requestId" value="${request.leaveRequestId}">
            <button type="submit" name="action" value="ACCEPTER">Accepter</button>
            <button type="submit" name="action" value="REFUSER">Refuser</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
