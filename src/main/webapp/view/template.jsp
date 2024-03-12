<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.1.js"></script>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<!-- 관리자 템플레이트  -->
	<c:if test="${Worker != null }">
		<jsp:include page="components/header.jsp" />
	</c:if>
	
	<main>
		<jsp:include page="${incUrl}"/>
	</main>
	
<%-- 	<jsp:include page="components/footer.jsp" /> --%>
</body>
</html>