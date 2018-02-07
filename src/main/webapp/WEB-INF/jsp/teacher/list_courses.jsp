<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Courses" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
            <%-- CONTENT --%>
                <table class="highlight">
                    <thead>
                    <tr>
                        <td>№</td>
                        <td>Name</td>

                    </tr>
                    </thead>
                    <tr>

                        <c:set var="k" value="0"/>
                        <c:forEach var="item" items="${coursesList}">
                        <td>${item.id}</td>
                        <td>${item.userName}</td>
                        <td>${item.courseName}</td>
                        <td>${item.courseMark}</td>
                        <td><input type="number" name="mark" value="${item.mark}"></td>
                    </tr>
                    </c:forEach>
                </table>

            </form>

            <%-- CONTENT --%>
        </td>
    </tr>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</table>
</body>
