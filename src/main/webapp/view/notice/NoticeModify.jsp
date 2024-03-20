
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>

<script>
	function fileDelete() {
		if (confirm("파일을 삭제하시겠습니까?")) {
			var noticeFileModify = document.querySelector("#noticeFileModify");
			noticeFileModify.action = "NoticeFileDelete";
			noticeFileModify.submit();
		} // 삭제 - true 면 사진을 지우기 -> 다시 업로드할 수 있도록 삭제 안보이기
	}
</script>

<form name="frm" action="NoticeModifyReg?"
	method="post" enctype="multipart/form-data" id="noticeFileModify">
	<input type="hidden" name="no" value="${ModifyData.no}"/>
	<div class="pos">
		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">제목</div>
			<div>
				<input type="text" name="title" value=${ModifyData.title }
					class="noticeContent_width" />
			</div>
		</div>

		 <%-- <div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">첨부파일</div>

			<div class="noticeModify_Img">
				<img alt="" src="/alienProtector/img/${ModifyData.img }"
					class="noticeModify_Img">
			</div>
		</div>


		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">파일</div>
			<div><input type="file" name="upfile" class="noticeContent_width2" /></div>
			<!-- <div><input type="button" value="삭제" onclick="fileDelete()" class="bnt"/></div> --> 
			<input type="hidden" name="upfile" value="${ModifyData.img}"/>
		</div>  --%>


		 <div class="noticeModify_titleWrap">
		 	<div class="noticeModify_title2">첨부파일</div>
		<c:choose>
			<c:when test="${ModifyData.img !=null}">
				<div class="noticeModify_Img" >
					<img alt="" src="/alienProtector/img/${ModifyData.img }"  class="noticeModify_Img">
				</div>
				
				
				<div class="abs" style="border: none; position: absolute; bottom:5px; right: 20px; width: 4%">
					<input type="button" value="삭제" onclick="fileDelete()"
						class="btn" />
				</div>
				
				<input type="hidden" name="upfile" value="${ModifyData.img}" />
			</c:when>
			<c:otherwise>
				<div>
					<input type="file" name="upfile" />
				</div>
			</c:otherwise>
		</c:choose>
		</div>
		



		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">내용</div>

			<div class="noticeModify_Img">
				<textarea name="content" rows="8" cols="168">${ModifyData.content }</textarea>
			</div>
		</div>
		<c:if test="${Worker.id=='master'}">
			<div class="Notice_under">
				<input type="submit" value="수정" class="btn" /> <input type="button"
					value="취소" class="btn" onclick="location.href='NoticeList'">
			</div>
		</c:if>
	</div>
</form>

