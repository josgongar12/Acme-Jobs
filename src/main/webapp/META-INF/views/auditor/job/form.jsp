<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="auditor.job.form.label.title" path="title"/>
	<acme:form-moment code="auditor.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="auditor.job.form.label.salary" path="salary"/>
	<acme:form-url code="auditor.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="auditor.job.form.label.description" path="description"/>
	<acme:form-url code="auditor.job.form.label.descriptorDescription" path="descriptorDescription"/>
	
	<acme:form-hidden path="id"/>
	<acme:form-submit code="auditor.job.form.label.duties" action="/authenticated/duty/list?id=${id}" method="get"/>
	
	<acme:form-submit code="auditor.job.form.label.audit" action="/authenticated/audit/list?id=${id}" method="get"/>	
	
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>
