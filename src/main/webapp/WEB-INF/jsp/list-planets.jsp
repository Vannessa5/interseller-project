<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/header.jspf" %>




<div class="container">
<div>
<a href="/calculate-distance" class="btn btn-primary">Calculate</a>
</div>
	<table class="table table-striped">
		<caption> Interstellar Planets</caption>
		<thead>
			<tr>
				<th>PLANET NODE</th>
				<th>PLANET NAME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${planets}" var="planet">
				<tr>
					<td>${planet.planetNode}</td>
					<td>${planet.planetName}</td>
				</tr>
			</c:forEach>
		</tbody>
			
	</table>
</div>

<%@ include file="common/footer.jspf" %>