<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div class="header">
		<div class="Log__info">
		<c:if test="${Worker != null }">		
			<p>어서오세요 ${Worker.name} 님 </p>
			<a href="/alienProtector/logout/Logout" class="btn">로그아웃</a>
		</c:if>
		</div>
		<div class="headerAdmin">
			<ul>
				<li><a href="/alienProtector/dashboard/dashboard">대시보드</a></li>
				<li><a href="/alienProtector/worker/WorkerList">근무자 명단</a></li>
				<li><a href="/alienProtector/work/WorkList">근무일지</a></li>
				<li><a href="/alienProtector/notice/NoticeList">공지사항</a></li>
				
			</ul>
		</div>
	</div>

</header>
