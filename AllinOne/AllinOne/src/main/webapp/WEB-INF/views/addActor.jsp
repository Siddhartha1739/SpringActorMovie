<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>Register Actor</h1>
<form action="/addedActor"  >

    <%--@declare id="actorid"--%>
        <%--@declare id="actorname"--%>
        <label for="ActorId">Enter Actor Id: </label>
    <input type="number"  name="ActorId"><br>
    <label for="ActorName">Enter Actor Name : </label>
    <input type="text"  name="ActorName"><br>
    <input type="submit" value="Submit">
</form>
</html>