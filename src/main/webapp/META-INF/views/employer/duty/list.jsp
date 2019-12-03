<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="employer.duty.list.label.title" path="title" width="34%"/>
	<acme:list-column code="employer.duty.list.label.dutyDescription" path="dutyDescription" width="33%"/>
	<acme:list-column code="employer.duty.list.label.percentage" path="percentage" width="33%"/>
</acme:list>