<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Connexion</title>
  <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Ajoutez votre CSS ici -->
</head>
<body>
<h2>Connexion</h2>
<form action="login" method="post">
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required>
  <br>
  <label for="password">Mot de passe:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <button type="submit">Se connecter</button>
</form>

<c:if test="${not empty errorMessage}">
  <div class="error">${errorMessage}</div>
</c:if>

<p>Pas encore inscrit ? <a href="register.jsp">Inscrivez-vous ici</a>.</p>
</body>
</html>
