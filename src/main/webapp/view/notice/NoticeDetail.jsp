<script>
	function del(){
		
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href = "NoticeDelete?no=3&$nowPage=3"
		}
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="Notice__box">
	
	<div class="Notice__listWrap">
		<div class="Notice__listinfo">
			<div>제목</div>
		</div>
		<div class="Notice__info">
			<div>등록시간</div>
			<div>조회수:1</div>
		</div>
		<hr>
		
		<c:if test="${Data.Img!=null}">
		<div class="Notice__content"><img alt="" src="/images/${Data.Img}"></div>
		</c:if>
		
		<div class="Notice__content">내용</div>
		
		<div class="Notice__menuba">
			<div class="Notice__status">
				<a href="NoticeList">목록으로 </a>
			</div>
				<div class="NoticeBoard__status">
				
					<a href="NoticeModifyForm?no=3&nowPage=3"> 수정 </a>
				</div>
				<div class="Notice__status">
					<a href="javascript:del()"> 삭제 </a>
				</div>
		</div>
	</div>
</div>