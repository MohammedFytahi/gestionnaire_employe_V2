<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calcul des Allocations Familiales</title>
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

    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      margin: auto;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
      color: #555;
    }

    input[type="number"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      margin-bottom: 20px;
      font-size: 16px;
    }

    button {
      background-color: #5cb85c;
      color: white;
      border: none;
      padding: 10px 15px;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      width: 100%;
    }

    button:hover {
      background-color: #4cae4c;
    }

    .message {
      text-align: center;
      margin-top: 20px;
      font-size: 18px;
      color: #007BFF;
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Calcul des Allocations Familiales</h1>
<form action="${pageContext.request.contextPath}/calculateAllowance" method="post">
  <label for="employeId">ID de l'employé:</label>
  <input type="number" id="employeId" name="employeId" required>
  <button type="submit">Calculer</button>
</form>
</body>
</html>
