<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:if test="${Worker == null }">
	<% response.sendRedirect("/alienProtector/login/Login");%>
</c:if>
<c:if test="${Worker.id == 'master' }">
	<% response.sendRedirect("/alienProtector/dashboard");%>
</c:if>
<c:if test="${Worker != null && Worker.id != 'master' }">
	<% response.sendRedirect("/alienProtector/patrol/PatrolWrite");%>
</c:if> --%>

<c:choose>
	<c:when test="${Worker == null }">
		<% response.sendRedirect("/alienProtector/login/Login");%>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${Worker.id == 'master' }">
				<% response.sendRedirect("/alienProtector/dashboard");%>
			</c:when>
			<c:otherwise>
				<% response.sendRedirect("/alienProtector/patrol/PatrolWrite");%>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>