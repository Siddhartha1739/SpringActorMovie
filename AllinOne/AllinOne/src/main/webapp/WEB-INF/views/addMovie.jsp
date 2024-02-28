<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>Register Movie</h1>
<form action="/addedMovies"  >

    <%--@declare id="movieid"--%><%--@declare id="movietitle"--%><%--@declare id="castid"--%><%--@declare id="producer"--%><%--@declare id="musicdirector"--%><%--@declare id="moviebudget"--%>
    <%--@declare id="directorname"--%><%--@declare id="directorid"--%>
        <label for="MovieId">Enter Movie Id: </label>
    <input type="number"  name="MovieId"><br>
    <label for="MovieTitle">Enter Movie Title : </label>
    <input type="text"  name="MovieTitle"><br>
    <label for="castId">Enter Cast Id : </label>
    <input type="number"  name="castId"><br>
    <label for="Producer">Enter Movie Producer: </label>
    <input type="text"  name="Producer"><br>
        <label for="MusicDirector">Enter Music Director: </label>
        <input type="text"  name="MusicDirector"><br>
        <label for="DirectorId">Enter Director Id : </label>
        <input type="number"  name="DirectorId"><br>
        <label for="DirectorName">Enter  Director Name: </label>
        <input type="text"  name="DirectorName"><br>
    <label for="MovieBudget">Enter Movie Budget : </label>
    <input type="number"  name="MovieBudget"><br>
    <input type="submit" value="Submit">
</form>
</html>