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
        <th>Producer</th>
        <th>MovieBudget</th>
        <th>Music Director</th>
        <th>Movie Director</th>
        <th>Add Actors</th>
        <th>View Actors</th>
        <th>Delete Movie</th>


    </tr>
    <%
        List<MovieModel> movieList = (List<MovieModel>) request.getAttribute("movieModelList");
        for (MovieModel movie : movieList) {
    %>
    <tr>
        <td><%=movie.getMovieId() %></td>
        <td><%= movie.getMovieTitle() %></td>
        <td><%= movie.getMovieCastModel().getProducer() %></td>
        <td><%= movie.getMovieCastModel().getMovieBudget() %></td>
        <td><%= movie.getMovieCastModel().getMusicDirector() %></td>
        <td><%= movie.getMovieDirector().getDirectorName() %></td>
        <td>
            <form action="assignActors" >
                <input type="hidden" name="empId" value="<%= movie.getMovieId() %>">
                <input type="submit" value="add Actors">
            </form>
        </td>
        <td>
            <form action="viewActorList" >
                <input type="hidden" name="MovieId" value="<%= movie.getMovieId() %>">
                <input type="submit" value="View Actors">
            </form>
        </td>
        <td>
            <form action="RemoveMovie" >
                <input type="hidden" name="MovieId" value="<%= movie.getMovieId()%>">
                <input type="hidden" name="ActorId" value=${ActorId}>
                <input type="submit" value="Remove Movie">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
