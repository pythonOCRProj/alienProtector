<style>
.SlaveBoard__listinfo {
	width: 1200px;
	margin: 10px;
	display: flex;
}

.Notice__box {
	width: 1200px;
}

.Notice__listWrap {
	width: 1200px;
	border: 1px solid rgb(192, 192, 192);
	margin: 10px 0px 0px 0px;
}

.Notice__info {
	display: flex;
	margin: 5px 5px 5px 730px;
}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="Notice__box">
	<div>공지사항</div>
	<div class="Notice__listWrap">
		<c:forEach items="${noticeData }" var="dto">
			<div class="Notice__listinfo">

				<div>
					[${dto.no }]<a href="NoticeDetail?no=${dto.no }">${dto.title}</a>
				</div>

				<div class="Notice__info">
					<div>등록일시: ${dto.time}</div>
					<div>조회수: ${dto.cnt }</div>
				</div>
			</div>
			<hr>
		</c:forEach>
	</div>
</div>

	<input type="button" value="글쓰기" onclick="location.href='NoticeWriteForm'"
		class="Notice__button">

