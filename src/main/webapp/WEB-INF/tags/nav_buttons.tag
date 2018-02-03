<%@ tag language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userRole == 'ADMIN'}">
    <li><a href="#">Set new teacher</a></li>
    <li><a href="#">Courses management</a></li>
    <li><a href="#">Students management</a></li>
</c:if>
<c:if test="${sessionScope.userRole == 'TEACHER'}">
    <li><a href="#">Editing courses</a></li>
</c:if>
<c:if test="${sessionScope.userRole == 'STUDENT'}">
    <li><a href="controller?command=listSchedule">All courses</a></li >
    <li><a href="controller?command=progressingCourses">Started courses</a></li>
    <li><a href="controller?command=pendingCourses">Pending courses</a></li>
    <li><a href="#">Finished courses</a></li>
</c:if>