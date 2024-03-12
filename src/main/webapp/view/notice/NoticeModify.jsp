
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
		<div>
			<div>제목</div>
			<div>
				<input type="text" name="title" value=${ModifyData.title } />
			</div>
		</div>
		<div>
			<div>파일</div>
			<div>
				<div>첨부파일</div>
				<div>
					<img alt="" src="/alienProtector/img/${ModifyData.img }">
				</div>
				<div>
					<input type="file" name="upfile" />
				</div>
			</div>
		</div>

		<div>
			<div>내용</div>

			<div>
				<textarea name="content" rows="8" cols="168">${ModifyData.content }</textarea>
			</div>
		</div>
		<div>
			<input type="submit" value="수정" /> <a href="NoticeList">취소</a>
		</div>
	</div>
</form>

