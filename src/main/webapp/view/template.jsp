<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<title>Insert title here</title>
<script src="../js/jquery-3.7.1.js"></script>
<script src="../js/address.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href="../css/style.css" rel="stylesheet">
</head>
<c:if test="${Worker.id == 'master' }">
	<body id ="masterTemplate">
<!-- 관리자 템플레이트  -->
		<jsp:include page="components/header.jsp" />

</c:if>

<c:if test="${Worker.id != 'master' }">
	<body id ="patrolTemplate">
		<c:if test="${Worker != null }">
			<jsp:include page="components/headerPatrol.jsp" />
		</c:if>
		
</c:if>
		<main>
			<jsp:include page="${incUrl}"/>
		</main>

	
<%-- 	<jsp:include page="components/footer.jsp" /> --%>
	</body>
</html>