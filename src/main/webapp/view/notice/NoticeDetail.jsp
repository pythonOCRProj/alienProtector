<script>
	function del(){
		
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href = "NoticeDelete?no=${dto.no }"
		}
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	
	<div>
		<div>
			<div>${noticeDetail.title}</div>
		</div>
		<div>
			<div>등록일시:${noticeDetail.time}</div>
			<div>조회수:${noticeDetail.cnt}</div>
		</div>
		<hr>
		
		<c:if test="${Data.Img!=null}">
		<div><img alt="" src="/images/${Data.Img}"></div>
		</c:if>
		
		<div>${noticeDetail.content}</div>
		
		<div>
			<div>
				<a href="NoticeList">목록으로 </a>
			</div>
				<div>
				
					<a href="NoticeModifyForm?no=${dto.no }"> 수정 </a>
				</div>
				<div>
					<a href="javascript:del()"> 삭제 </a>
				</div>
		</div>
	</div>
</div>