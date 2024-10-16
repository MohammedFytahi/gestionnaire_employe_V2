<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Montant des allocations familiales</title>
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

    p {
      font-size: 20px;
      text-align: center;
      color: #555;
      margin: 20px 0;
    }

    a {
      display: inline-block;
      background-color: #007BFF;
      color: white;
      padding: 10px 15px;
      border-radius: 4px;
      text-decoration: none;
      text-align: center;
      font-size: 16px;
      transition: background-color 0.3s;
      margin: 0 auto;
      width: 200px;
    }

    a:hover {
      background-color: #0056b3;
    }

    .container {
      max-width: 600px;
      margin: 0 auto;
      background-color: white;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<body>

<div class="container">
  <h1>Allocations Familiales pour l'Employé</h1>
  <p>Le montant des allocations familiales est de : <strong>${allowance} DH</strong></p>
  <a href="adminDashboard.jsp">Retour à l'administration</a>
</div>
</body>
</html>
