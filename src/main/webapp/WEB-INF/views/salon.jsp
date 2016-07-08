<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Salon Page</title>
	<link href="<c:url value="/resources/css/salon.css" />" rel="stylesheet">
</head>
<body>
<h1>

	Ajouter un Salon


</h1>

<c:url var="addAction" value="/salon/add" ></c:url>
<div id=registration >
<form:form action="${addAction}" commandName="salon">
<table>
	<c:if test="${!empty salon.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Nom"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="ville">
				<spring:message text="Ville"/>
			</form:label>
		</td>
		<td>
			<form:input path="ville" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="quartier">
				<spring:message text="Quartier"/>
			</form:label>
		</td>
		<td>
			<form:input path="quartier" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="numtel">
				<spring:message text="Numero de Telephone"/>
			</form:label>
		</td>
		<td>
			<form:input path="numtel" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty salon.name}">
				<input type="submit"
					value="<spring:message text="Modifier"/>" />
			</c:if>
			<c:if test="${empty salon.name}">
				<input id="bouton" type="submit"
					value="<spring:message text="Ajouter"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</div>
<br>

</body>
</html>
