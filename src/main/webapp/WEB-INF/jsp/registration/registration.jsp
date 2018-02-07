<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="SignUp" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<body>
<form action="controller" method="POST">
    <input type="hidden" name="command" value="registration">
    <div class="row">
        <form class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input placeholder="" id="name" type="text" class="validate">
                    <label for="name">Name</label>
                </div>
            </div>
            <div class="row">

            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="email" type="email" class="validate">
                    <label for="email">Email</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="password" type="password" class="validate">
                    <label for="password">Password</label>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="active" type="boolean" class="validate">
                        <label for="active">Active</label>
                    </div>
            </div>
        </form>
    </div>



</form>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>