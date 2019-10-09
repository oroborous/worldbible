<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
    <title>${viewNpc.nickname}</title>
</head>
<body>
<%@ include file="/WEB-INF/resources/menu.html" %>

<form:form modelAttribute="viewNpc" action="characterEdit">
    <div class="character-view">
        <img src="resources/img/${editNpc.primaryImageFilename}" width="212" height="278" alt="${editNpc.nickname}"/>

        <div class="character-info">
            <label for="firstName">First Name</label>
            <form:input path="firstName" id="firstName"/>
            <label for="lastName">Last Name</label>
            <form:input path="lastName" id="lastName"/>
            <label for="nickname">Nickname</label>
            <form:input path="nickname" id="nickname"/>
            <label for="occupation">Occupation</label>
            <form:input path="occupation" id="occupation"/>
            <label for="sex">Sex</label>
            <form:input path="sex" id="sex"/>

            <form:input type="hidden" path="id"/>
            <input type="submit" value="Edit"/>
        </div>

        <div class="character-bio">
            <h3>Bio</h3>
            <form:textarea path="bio" cols="50" rows="10"></form:textarea>
        </div>

        <div class="character-quests">
            <h3>Quests</h3>
            <textarea name="quests" cols="50" rows="10"></textarea>
        </div>
    </div>
</form:form>
<footer><a href="mailto:sread@wctc.edu">Stacy Read</a> &copy; 2019</footer>
</body>
</html>
