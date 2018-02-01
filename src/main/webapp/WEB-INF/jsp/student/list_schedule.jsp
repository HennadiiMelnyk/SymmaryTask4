<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Schedule" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">
			
		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
			<td class="content">			
			<%-- CONTENT --%>
			
			<form id="courses" action="controller">
				<input type="hidden" name="command" value="courses"/>
				<input value="Make an order" type="submit"/>
			
				<table id="list_schedule_table">
					<thead>
						<tr>
							<td>№</td>
							<td>Name</td>
							<td>mark</td>
							<td>progress</td>
						</tr>
					</thead>
					<c:set var="k" value="${k+1}"/>
					<tr>

					<c:set var="k" value="0"/>
					<c:forEach var="item" items="${coursesList}">
							<td>${item.id}</td>
							<td>${item.course}</td>
							<td>${item.user}</td>
							<td>${item.mark}</td>
							<td>${item.progress}</td>
							<td><input type="checkbox" name="itemId" value="${item.id}"/></td>
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
