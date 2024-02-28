<%@ page import="java.util.List" %>
<%@ page import="com.example.AllinOne.Models.ActorModel" %>


<!DOCTYPE html>
<html>
<head>
    <title>Actor List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Movie List</h1>
<table border="1">
    <tr>
        <th>Actor ID</th>
        <th>Actor Name</th>
        <th>Add Movies</th>
        <th>View Movies</th>
        <th>Delete Actor</th>


    </tr>
    <%
        List<ActorModel> actorModelList = (List<ActorModel>) request.getAttribute("actorModelList");
        for (ActorModel actorModel : actorModelList) {
    %>
    <tr>
        <td><%=actorModel.getActorId() %></td>
        <td><%= actorModel.getActorName() %></td>

        <td>
            <form action="assignMovies" >
                <input type="hidden" name="ActorId" value="<%=actorModel.getActorId() %>">
                <input type="submit" value="add Movies">
            </form>
        </td>
        <td>
            <form action="viewMovieList" >
                <input type="hidden" name="ActorId" value="<%= actorModel.getActorId() %>">
                <input type="submit" value="View Movies">
            </form>
        </td>
        <td>
            <form action="RemoveActor" >
                <input type="hidden" name="ActorId" value="<%= actorModel.getActorId()%>">
                <input type="hidden" name="MovieId" value=${MovieId}>
                <input type="submit" value="Remove Actor">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
