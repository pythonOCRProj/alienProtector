
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>

<script>
	function fileDel() {

		if (confirm("파일을 삭제하시겠습니까?\n삭제된파일은 복구불가입니다.")) {
			var frm = document.frm;
			frm.action = "FileDelete"
			frm.submit()
		}
	}
</script>

<form name="frm" action="NoticeModifyReg?no=${ModifyData.no}"
	method="post" enctype="multipart/form-data">
	<div>
		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">제목</div>
			<div>
				<input type="text" name="title" value=${ModifyData.title }
					class="noticeContent_width" />
			</div>
		</div>

		<div class="noticeModify_fileWrap">
			<div class="noticeModify_title2">첨부파일</div>

			<div class="noticeModify_Img">
				<img alt="" src="/alienProtector/img/${ModifyData.img }"
					class="noticeModify_Img">
			</div>
		</div>


		<div class="">
			<input type="file" name="upfile" />
		</div>

		<div class="noticeModify_content">
			<div class="noticeModify_title">내용</div>

			<div class="noticeModify_con">
				<textarea name="content" rows="8" cols="168">${ModifyData.content }</textarea>
			</div>
		</div>
		<c:if test="${Worker.id=='master'}">
			<div class="Notice_under">
				<input type="submit" value="수정" /> <input type="button" value="취소"
					onclick="location.href='NoticeList'">
			</div>
		</c:if>
	</div>
</form>

