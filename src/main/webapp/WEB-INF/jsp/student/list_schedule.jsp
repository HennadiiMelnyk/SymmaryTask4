<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>



<html>

<c:set var="title" value="Schedule" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<table class="highlight">
    <thead>
    <tr>
        <td>№</td>
        <td>Course</td>
        <td>Mark</td>
        <td>Progress</td>
    </tr>
    </thead>
    <tr>

        <c:set var="k" value="0"/>
        <c:forEach var="item" items="${coursesList}">
        <td>${item.id}</td>
        <td>${item.course}</td>
        <td>${item.mark}</td>
        <td>${item.progress}</td>
    </tr>
    </c:forEach>
</table>

<form>

</form>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
