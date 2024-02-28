<%@ page import="java.util.List" %>
<%@ page import="com.example.AllinOne.Models.MovieModel" %>


<!DOCTYPE html>
<html>
<head>
    <title>Movie List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Movie List</h1>
<table border="1">
    <tr>
        <th>Movie ID</th>
        <th>Title</th>


    </tr>
    <tr>
        <td>${id}</td>
        <td>${title}</td>
    </tr>
</table>

<a href="first">First Page</a>
</body>
</html>
