<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="Notice_box">
	<div class="Notice_head">공지사항</div>

	<hr>
	<div class="Notice_listinfo">
		<div class="Notice_title">제목</div>
		<div class="Notice_date">등록일시</div>
		<div class="Notice_cnt">조회수</div>
	</div>
	<hr>

	<c:forEach items="${noticeData }" var="dto">
		<a href="NoticeDetail?no=${dto.no }">
			<div class="Notice_info">
				<div class="Notice_title2">${dto.title}</div>
				<div class="Notice_date2">${dto.timeStr}</div>
				<div class="Notice_cnt2">${dto.cnt }</div>
			</div>
		</a>
		<hr>
	</c:forEach>
</div>
