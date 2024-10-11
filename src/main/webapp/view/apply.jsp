<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Apply for Job Offer</title>
  <style>
    /* Add your CSS styles ici */
  </style>
</head>
<body>
<h1>Apply for: ${offre.title}</h1>
<div class="form-container">
  <form action="<c:url value='/ApplicationServlet' />" method="post">
    <label for="candidateName">Candidate Name:</label>
    <input type="text" id="candidateName" name="candidateName" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="skills">Skills (comma-separated):</label>
    <textarea id="skills" name="skills" required></textarea>


    <input type="hidden" name="offreId" value="${offre.id}">

    <button type="submit">Submit Application</button>
  </form>
</div>
</body>
</html>
