<%@ include file="/WEB-INF/template/include.jsp"%>

<openmrs:require privilege="Manage Concept Name Tags"
	otherwise="/login.htm"
	redirect="/module/conceptsearch/conceptNameTagForm.form" />

<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="localHeader.jsp"%>


<h2>
	<spring:message code="conceptsearch.conceptnametaglistheading" />
</h2>


<br />
<openmrs:extensionPoint
	pointId="org.openmrs.admin.concepts.conceptNameTagForm.afterTitle"
	type="html"
	parameters="conceptNameTagId=${conceptNameTag.conceptNameTagId}" />


<form method="post">
	<fieldset>
		<table>
			<tr>
				<td><spring:message code="general.name" /></td>
				<td><spring:bind path="conceptNameTag.tag">
						<input type="text" name="tag" value="${status.value}" size="35" />
						<c:if test="${status.errorMessage != ''}">
							<span class="error">${status.errorMessage}</span>
						</c:if>
					</spring:bind></td>
			</tr>
			<tr>
				<td valign="top"><spring:message code="general.description" /></td>
				<td><spring:bind path="conceptNameTag.description">
						<textarea name="description" rows="3" cols="40">${status.value}</textarea>
						<c:if test="${status.errorMessage != ''}">
							<span class="error">${status.errorMessage}</span>
						</c:if>
					</spring:bind></td>
			</tr>
			<c:if test="${!(conceptNameTag.creator == null)}">
				<tr>
					<td><spring:message code="general.createdBy" /></td>
					<td>${conceptNameTag.creator.personName} - <openmrs:formatDate
							date="${conceptNameTag.dateCreated}" type="long" />
					</td>
				</tr>
			</c:if>
		</table>
		<openmrs:extensionPoint
			pointId="org.openmrs.admin.concepts.conceptNameTagForm.inForm"
			type="html"
			parameters="conceptNameTagId=${conceptNameTag.conceptNameTagId}" />
		<br /> <input type="submit"
			value="<spring:message code="conceptsearch.savetag"/>">
		&nbsp; <input type="button"
			value='<openmrs:message code="general.cancel"/>'
			onclick="history.go(-1); return; document.location='index.htm?autoJump=false&phrase=<request:parameter name="phrase"/>'">
	</fieldset>
</form>
<br />
<br />
<openmrs:extensionPoint
	pointId="org.openmrs.admin.concepts.conceptNameTagForm.footer"
	type="html"
	parameters="conceptNameTagId=${conceptNameTag.conceptNameTagId}" />

<%@ include file="/WEB-INF/template/footer.jsp"%>