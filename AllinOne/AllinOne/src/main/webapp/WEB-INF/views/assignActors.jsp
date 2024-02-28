<%@page language="java" %>
<html>
<h1>Add Actor to Movie</h1>
<form action="/assignedActors"  >
    <%--@declare id="actorid"--%>
    <label for="ActorId">Enter Actor Id: </label>
    <input type="number"  name="ActorId"><br>
    <input type="hidden" name="MovieId" value=${MovieId}>
    <input type="submit" value="Submit">
</form>
</html>