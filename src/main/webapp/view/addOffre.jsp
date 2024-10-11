<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Job Offer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .form-container {
            max-width: 500px;
            margin: 0 auto; /* Center the form */
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        textarea,
        select {
            width: 100%; /* Full width */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Include padding in width */
        }

        button {
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            width: 100%; /* Full width */
        }

        button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
<h1>Add a New Job Offer</h1>

<div class="form-container">
    <form action="<c:url value='/addOffre' />" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>

        <label for="requirements">Requirements:</label>
        <textarea id="requirements" name="requirements" required></textarea>

        <label for="validityPeriode">Validity Period:</label>
        <input type="date" id="validityPeriode" name="validityPeriode" required>

        <label for="statut">Status:</label>
        <select id="statut" name="statut" required>
            <option value="RECU">RECU</option>
            <option value="EN_COURS">EN_COURS</option>
            <option value="REJETE">REJETE</option>
            <option value="ACCEPTE">ACCEPTE</option>
        </select>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
