<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Liste des candidatures</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    form {
      text-align: center;
      margin-bottom: 20px;
    }

    input[type="text"] {
      padding: 10px;
      width: 300px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-right: 10px;
    }

    input[type="submit"] {
      padding: 10px 20px;
      background-color: #007BFF;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
      background-color: #0056b3; /* Darker blue on hover */
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
      background-color: white;
    }

    th {
      background-color: #007BFF;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1; /* Highlight row on hover */
    }

    .no-applications {
      text-align: center;
      margin-top: 20px;
      font-weight: bold;
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Liste des candidatures</h1>

<form action="${pageContext.request.contextPath}/ApplicationServlet" method="get">
  <input type="text" name="skills" placeholder="Filtrer par compétences (séparées par des virgules)" />
  <input type="submit" value="Filtrer"/>
</form>

<table>
  <tr>
    <th>ID</th>
    <th>Nom du candidat</th>
    <th>Email</th>
    <th>Compétences</th>
  </tr>
  <c:forEach var="application" items="${applications}">
    <tr>
      <td>${application.id}</td>
      <td>${application.candidateName}</td>
      <td>${application.email}</td>
      <td>
        <c:if test="${not empty application.skills}">
          <c:forEach var="skill" items="${application.skills}">
            ${skill}<br/>
          </c:forEach>
        </c:if>
        <c:if test="${empty application.skills}">
          Aucune compétence renseignée
        </c:if>
      </td>
    </tr>
  </c:forEach>
</table>

<c:if test="${empty applications}">
  <p class="no-applications">Aucune candidature trouvée.</p>
</c:if>
</body>
</html>
