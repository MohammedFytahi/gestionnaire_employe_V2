<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>List of Job Offers</title>
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

    .container {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      gap: 20px; /* Space between cards */
    }

    .card {
      background-color: white;
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 20px;
      width: 300px; /* Width of the card */
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
      transition: transform 0.2s;
    }

    .card:hover {
      transform: scale(1.05); /* Slightly enlarge the card on hover */
    }

    .card-title {
      font-size: 1.5em;
      margin: 0;
    }

    .card-text {
      margin: 10px 0;
    }

    .btn {
      display: inline-block;
      background-color: #007BFF;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      text-decoration: none; /* Remove underline from links */
      text-align: center;
      transition: background-color 0.3s;
    }

    .btn:hover {
      background-color: #0056b3; /* Darker blue on hover */
    }

    .add-offer {
      text-align: center; /* Center align the button */
      margin-bottom: 20px; /* Space below the button */
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>List of Job Offers</h1>


<c:if test="${not empty sessionScope.user && sessionScope.user.role == 'RH'}">
  <div class="add-offer">
    <a href="addOffre" class="btn">Ajouter une offre</a>
  </div>
</c:if>

<div class="container">
  <c:forEach var="offre" items="${offres}">
    <div class="card">
      <h5 class="card-title">${offre.title}</h5>
      <p class="card-text">${offre.description}</p>
      <p class="card-text"><strong>Exigences:</strong> ${offre.requirements}</p>
      <p class="card-text"><strong>Période de validité:</strong> ${offre.validityPeriode}</p>
      <p class="card-text"><strong>Statut:</strong> ${offre.statut}</p>

      <c:choose>
        <c:when test="${empty sessionScope.user}">
          <a href="<c:url value='/AddApplicationServlet?offreId=${offre.id}' />" class="btn">Postuler</a>
        </c:when>
        <c:otherwise>

        </c:otherwise>
      </c:choose>
    </div>
  </c:forEach>
</div>
</body>
</html>
