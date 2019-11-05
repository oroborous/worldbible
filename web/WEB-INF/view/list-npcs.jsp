<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List NPCs</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>All NPCs</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <!-- add HTML table here -->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Nickname</th>
                <th>Occupation</th>
            </tr>
            <c:forEach var="tempNpc" items="${npcs}">
                <tr>
                    <td>${tempNpc.firstName}</td>
                    <td>${tempNpc.lastName}</td>
                    <td>${tempNpc.nickname}</td>
                    <td>${tempNpc.occupation}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
