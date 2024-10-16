<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Connexion</title>
  <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Ajoutez votre CSS ici -->
  <style>
    body {
      font-family: 'Arial', sans-serif; /* Use a modern font */
      background-color: #e9ecef; /* Light gray background */
      margin: 0; /* Remove default margin */

      align-content: center; /* Center horizontally */

      align-items: center; /* Center vertically */
      height: 100vh; /* Full viewport height */
    }

    .container{
      display: flex;
      justify-content: center;
    }
    h2 {
      text-align: center; /* Center align the heading */
      color: #343a40; /* Darker color for the heading */
      margin-bottom: 20px; /* Space below heading */
    }

    form {
      background-color: #ffffff; /* White background for form */
      margin-x: 100px;
      padding: 30px; /* Padding for the form */
      border-radius: 8px; /* Rounded corners */
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Shadow effect */
      width: 400px; /* Fixed width for form */
      display: grid; /* Use grid layout for form */
      gap: 15px; /* Space between form elements */
    }

    label {
      font-weight: bold; /* Bold text for labels */
      color: #495057; /* Dark color for labels */
    }

    input[type="email"],
    input[type="password"] {
      width: 100%; /* Full width inputs */
      padding: 12px; /* Padding for inputs */
      border: 1px solid #ced4da; /* Light border */
      border-radius: 5px; /* Rounded corners for inputs */
      font-size: 16px; /* Font size for inputs */
    }

    input[type="email"]:focus,
    input[type="password"]:focus {
      border-color: #80bdff; /* Blue border on focus */
      outline: none; /* Remove outline */
    }

    button {
      background-color: #007BFF; /* Blue background for button */
      color: white; /* White text */
      border: none; /* No border */
      padding: 12px; /* Padding for button */
      border-radius: 5px; /* Rounded corners for button */
      cursor: pointer; /* Pointer cursor on hover */
      font-size: 16px; /* Font size */
      transition: background-color 0.3s; /* Smooth transition */
    }

    button:hover {
      background-color: #0056b3; /* Darker blue on hover */
    }

    .error {
      color: #dc3545; /* Red color for error messages */
      text-align: center; /* Center align error messages */
      margin-top: 10px; /* Space above error messages */
    }

    p {
      text-align: center; /* Center align text */
      margin-top: 15px; /* Space above paragraph */
      font-size: 14px; /* Font size */
    }

    a {
      color: #007BFF; /* Link color */
      text-decoration: none; /* Remove underline */
    }

    a:hover {
      text-decoration: underline; /* Underline on hover */
    }
  </style>
</head>
<body>
<h2>Connexion</h2>
<div class="container">
  <form action="login" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Mot de passe:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Se connecter</button>
  </form>
</div>


<c:if test="${not empty errorMessage}">
  <div class="error">${errorMessage}</div>
</c:if>

<p>Pas encore inscrit ? <a href="register.jsp">Inscrivez-vous ici</a>.</p>
</body>
</html>
