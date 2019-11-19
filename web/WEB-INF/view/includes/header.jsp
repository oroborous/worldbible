<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<header class="header">
    <img src="${contextPath}/resources/img/logo.jpg" height="177" width="236" alt="World Bible Logo">
    <h1>World Bible</h1>
</header>
<nav class="navigation">
    <p class="menu-item"><a href="${contextPath}">Home</a></p>
    <p class="menu-item"><a href="${contextPath}/characters">Characters</a></p>
    <p class="menu-item"><a href="${contextPath}/locations">Locations</a></p>
    <p class="menu-item"><a href="${contextPath}/creatures">Creatures</a></p>
    <p class="menu-item"><a href="${contextPath}/lore">Lore</a></p>
    <p class="menu-item" id="login"><a href="${contextPath}/login">Login</a></p>
</nav>
