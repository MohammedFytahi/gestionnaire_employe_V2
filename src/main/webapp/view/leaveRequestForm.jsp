<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Demande de congé</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }

    .form-container {
      max-width: 500px; /* Limit the form width */
      margin: 0 auto; /* Center the form on the page */
      background-color: white;
      padding: 20px;
      border-radius: 8px; /* Round corners */
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Light shadow for the form */
    }

    label {
      display: block; /* Display labels as block elements */
      margin-bottom: 5px; /* Spacing between label and input */
      color: #555; /* Label text color */
    }

    input[type="date"],
    textarea,
    input[type="file"] {
      width: 100%; /* Inputs take full width */
      padding: 10px; /* Internal spacing */
      margin-bottom: 15px; /* Spacing between fields */
      border: 1px solid #ddd; /* Light gray border */
      border-radius: 4px; /* Round corners */
      font-size: 14px; /* Font size */
      transition: border-color 0.3s; /* Animation for border color */
    }

    input[type="date"]:focus,
    textarea:focus,
    input[type="file"]:focus {
      border-color: #007BFF; /* Blue border on focus */
      outline: none; /* Remove default outline */
    }

    input[type="submit"] {
      background-color: #007BFF; /* Button color */
      color: white; /* Button text color */
      padding: 10px 15px; /* Internal spacing */
      border: none; /* No border */
      border-radius: 5px; /* Round corners */
      cursor: pointer; /* Pointer cursor on hover */
      font-size: 16px; /* Font size */
      transition: background-color 0.3s; /* Animation for background color */
      width: 100%; /* Full width */
    }

    input[type="submit"]:hover {
      background-color: #0056b3; /* Darker color on hover */
    }

    /* Responsive design for smaller screens */
    @media (max-width: 480px) {
      .form-container {
        padding: 15px;
      }

      input[type="date"],
      textarea,
      input[type="file"],
      input[type="submit"] {
        font-size: 14px; /* Adjust font size for smaller screens */
      }
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="form-container">
  <h2>Soumettre une demande de congé</h2>
  <form action="${pageContext.request.contextPath}/submitLeaveRequest" method="post" enctype="multipart/form-data">
    <label for="startDate">Date de début :</label>
    <input id="startDate" type="date" name="startDate" required>

    <label for="endDate">Date de fin :</label>
    <input id="endDate" type="date" name="endDate" required>

    <label for="leaveReason">Motif :</label>
    <textarea id="leaveReason" name="leaveReason" required></textarea>

    <label for="supportingDocs">Documents justificatifs :</label>
    <input id="supportingDocs" type="file" name="supportingDocs">

    <input type="submit" value="Soumettre la demande">
  </form>
</div>
</body>
</html>
