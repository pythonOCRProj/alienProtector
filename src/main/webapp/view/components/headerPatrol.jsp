<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div class="header">
		<div class="Log__info">
		<c:if test="${Worker != null }">		
			<p>어서오세요 ${Worker.name} 님</p>
			<a class="btn" href="/alienProtector/logout/Logout">로그아웃</a>
		</c:if>
		</div>
		
		<div class="headerPatrol">
			<ul>
				<li><a href="/alienProtector/patrol/PatrolWrite">순찰등록</a></li>
				<li><a href="/alienProtector/notice/NoticePatrolList">공지사항</a></li>
			</ul>
		</div>
	</div>
	
</header>
