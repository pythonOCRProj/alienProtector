<script>
	
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div>
	<div class="noticeDetail_Wrap">
		<div class="noticeDetail_info">
			<div>
				<div class="noticeDetail_date">${noticeDetail.title}</div>
				<div class="noticeDetail_date">${noticeDetail.time}</div>
			</div>
		</div>
		<c:if test="${noticeDetail.img!=null}">
			<div class="noticeDetail_Img">
				<img alt="" src="/alienProtector/img/${noticeDetail.img}">
			</div>
		</c:if>
		<div class="noticeDetail_content">
			<div>${noticeDetail.content}</div>
		</div>
	</div>



	<div>
		<div>
			<a href="NoticeList">목록으로 </a>
		</div>

		<c:if test="${Worker.id=='master'}">
			<div>
				<a href="NoticeModify?no=${noticeDetail.no}"> 수정 </a>
			</div>
			<div>
				<a href="NoticeDelete?no=${noticeDetail.no}"> 삭제 </a>
			</div>
		</c:if>

	</div>
</div>






<%-- <div>
			<div>${noticeDetail.title}</div>
		</div>
		<div>
			<div>등록일시:${noticeDetail.time}</div>
			<div>조회수:${noticeDetail.cnt}</div>
		</div>
		<hr>

		<c:if test="${noticeDetail.img!=null}">
			<div>
				<img alt="" src="/alienProtector/img/${noticeDetail.img}">
			</div>
		</c:if>

		<div>${noticeDetail.content}</div>

		<div>
			<div>
				<a href="NoticeList">목록으로 </a>
			</div>
			
			<c:if test="${Worker.id=='master'}">
				<div>
					<a href="NoticeModify?no=${noticeDetail.no}"> 수정 </a>
				</div>
				<div>
				<a href="NoticeDelete?no=${noticeDetail.no}"> 삭제 </a>
			</div>
			</c:if>
			
		</div> --%>

