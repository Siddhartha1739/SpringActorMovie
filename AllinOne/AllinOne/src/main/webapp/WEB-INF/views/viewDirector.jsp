<%@ page import="java.util.List" %>
<%@ page import="com.example.AllinOne.Models.MovieModel" %>
<%@ page import="com.example.AllinOne.Models.DirectorModel" %>


<!DOCTYPE html>
<html>
<head>
    <title>Director List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Directors List</h1>
<table border="1">
    <tr>
        <th>Director ID</th>
        <th>Director Name</th>
        <th>View Movies</th>
        <th>Delete Director</th>


    </tr>
    <%
        List<DirectorModel> directorList = (List<DirectorModel>) request.getAttribute("directorList");
        for (DirectorModel director : directorList) {
    %>
    <tr>
        <td><%=director.getDirectorId()%></td>
        <td><%= director.getDirectorName() %></td>
        <td>
            <form action="viewDirectorMovies" >
                <input type="hidden" name="DirectorId" value="<%= director.getDirectorId() %>">
                <input type="submit" value="View Movies">
            </form>
        </td>
        <td>
            <form action="deleteDirector" >
                <input type="hidden" name="DirectorId" value="<%=director.getDirectorId()%>">
                <input type="submit" value="Delete Director">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
