<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${Worker == null }">
	<% response.sendRedirect("/alienProtector/login/Login");%>
</c:if>
<c:if test="${Worker.id == 'master' }">
	<% response.sendRedirect("/alienProtector/dashboard");%>
</c:if>
<c:if test="${Worker != null && Worker.id != 'master' }">
	<% response.sendRedirect("/alienProtector/patrol/PatrolWrite");%>
</c:if>