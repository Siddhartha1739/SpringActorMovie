<%@page language="java" %>
<html>
<h1>Add Movie to Actor</h1>
<form action="/assignedMovies"  >
    <%--@declare id="movieid"--%>
    <label for="MovieId">Enter Movie Id: </label>
    <input type="number"  name="MovieId"><br>
        <input type="hidden" name="ActorId" value=${ActorId}>
    <input type="submit" value="Submit">
</form>
</html>