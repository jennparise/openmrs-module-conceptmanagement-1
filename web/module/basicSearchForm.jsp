<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<openmrs:require privilege="View Concepts" otherwise="/login.htm" />

<h2><spring:message code="conceptmanagement.heading" /></h2>

<br />
<form method="post" class="box">
<table>
	<tr>
		<td><input type="text" name="conceptQuery" size="20"
			value="${conceptSearch.searchQuery}"></td>
		<td><input type="submit"
			value="<spring:message code="conceptmanagement.go" />"></td>
	</tr>
</table>
</form>
<c:if test="${!(searchResult == null)}">
	<dir>
		returned ${fn:length(searchResult)} results
	</dir>
</c:if>
<div class="boxHeader"><b><spring:message
	code="conceptmanagement.concepts" /></b></div>
<div class="box">
<table>
	<tr>
		<th><spring:message code="conceptmanagement.actions" /></th>
		<th><spring:message code="conceptmanagement.concept" /></th>
		<th><spring:message code="conceptmanagement.class" /></th>
		<th><spring:message code="conceptmanagement.datatype" /></th>
	</tr>
	<c:forEach var="concept" items="${searchResult}">
		<tr>
			<td><a
				href="../../dictionary/concept.htm?conceptId=${concept.conceptId}"><spring:message
				code="conceptmanagement.view" /></a></td>
			<td>${concept.names}</td>
			<td>${concept.conceptClass.name}</td>
			<td>${concept.datatype.name}</td>
		</tr>
	</c:forEach>
</table>
</div>
<b>Previous searches:</b>
<c:forEach var="prevSearch" items="${conceptSearch.searchTerms}">
${prevSearch}<br />
</c:forEach>

<%@ include file="/WEB-INF/template/footer.jsp"%>