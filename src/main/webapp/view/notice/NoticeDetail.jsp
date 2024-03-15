
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function del(no) {
		if(confirm("삭제하시겠습니까?")){
			location.href = "NoticeDelete?no="+no;
		}
	}
</script>

<div>
	<div class="noticeDetail_Wrap">
		<div class="noticeDetail_info">
			<div>
				<div class="noticeDetail_date">${noticeDetail.title}</div>
				<div class="noticeDetail_date">${noticeDetail.timeStr}</div>
			</div>
		</div>
		<hr>
		<c:if test="${noticeDetail.img!=null}">
			<div class="noticeModify_Img">
				<img alt="" src="/alienProtector/img/${noticeDetail.img}" class="noticeModify_Img">
			</div>
		</c:if>
		<div class="noticeDetail_content">
			<div>${noticeDetail.content}</div>
		</div>
	</div>



	<div class="notice_underbar">
	<c:if test="${Worker.id=='master'}">
		<div>
			<input type="button" value="목록" onclick="location.href='NoticeList'" class="btn">
		</div>
	</c:if>
	<c:if test="${Worker.id!='master'}">
		<div>
			<input type="button" value="목록" onclick="location.href='NoticePatrolList'" class="btn">
		</div>
	</c:if>
	
		<c:if test="${Worker.id=='master'}">
			<div >
				<input type="button" value="수정"
					onclick="location.href='NoticeModify?no=${noticeDetail.no}'" class="btn">
			</div>
			<div>
				<input type="button" value="삭제"  onclick="del(${noticeDetail.no})" class="btn">
			</div>
	</div>
	</c:if>

</div>


