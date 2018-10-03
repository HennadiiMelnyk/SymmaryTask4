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
        <form class="col s6">
            <div class="row">
                <div class="input-field col s6">
                    <input  id="name" type="text" class="validate">
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
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="active" type="text" class="validate">
                    <label for="active">Active</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="role" type="text" class="validate">
                    <label for="role">role</label>
                </div>
            </div>
        </form>
    </div>

</form>
<form class="modal-sm" action="controller?command=signUp" method="post">
    <input type="hidden" name="command" value="add"/>
    <button class="btn-floating btn-large waves-effect waves-light red" type="submit" name="action"><i class="material-icons">add</i></button>

</form>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>