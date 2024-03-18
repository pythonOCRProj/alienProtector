<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
	
<form action="NoticeWriteReg" method="post"
	enctype="multipart/form-data">


	<div class="noticeDetial_magin">
		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">제목</div>
			<div>
				<input type="text" name="title" 
					class="noticeContent_width" />
			</div>
		</div>

		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">파일</div>
			<div>
				<input type="file" name="upfile" class="noticeContent_width2" />
			</div>
		</div>

		<div class="noticeModify_titleWrap">
			<div class="noticeModify_title2">내용</div>

			<div class="noticeModify_Img">
				<textarea name="content" rows="8" cols="168">${ModifyData.content }</textarea>
			</div>
		</div>
		<div class="notice_underbar">
			<input type="button" value="목록보기"
				onclick="location.href='NoticeList'" class="btn"> <input type="submit"
				value="작성" class="btn" /> <input type="button" value="취소"
				onclick="location.href='NoticeList'" class="btn">


		</div>
	</div>
</form>


