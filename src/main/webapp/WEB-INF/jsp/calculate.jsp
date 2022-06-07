<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common/header.jspf" %>
    
    <div class="container">
	<form:form method="post" modelAttribute="calculateForm">
		<fieldset class="form-group">
			<form:label path="planetOrigin">Origin Planet</form:label>
			<form:input path="planetOrigin" type="text" class="form-control"
				required="required" />
			<form:errors path="planetOrigin" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="planetDestination">Destination Planet</form:label>
			<form:input path="planetDestination" type="text" class="form-control"
				required="required" />
			<form:errors path="planetDestination" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Calculate</button>
	</form:form>
</div>

<div class="container">
	<table class="table table-striped">
		<caption>ShORTEST PATH</caption>
		<thead>
			<tr>
				<th>PLANET NODE</th>
				<th>PLANET NAME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nodes}" var="node">
				<tr>
					<td>${node.planetNode}</td>
					<td>${node.planetName}</td>
				</tr>
			</c:forEach>
		</tbody>
			
	</table>
</div>

<%@ include file="common/footer.jspf" %>