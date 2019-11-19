<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>World Bible</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>

<jsp:include page="/WEB-INF/view/includes/header.jsp"/>

<div class="main">
    <p class="category"><a href="npc/list">Characters</a></p>
    <p class="category"><a href="locations.html">Locations</a></p>
    <p class="category"><a href="creatures.html">Creatures</a></p>
    <p class="category"><a href="lore.html">Lore</a></p>
</div>

<jsp:include page="/WEB-INF/view/includes/footer.jsp"/>

</body>
</html>
