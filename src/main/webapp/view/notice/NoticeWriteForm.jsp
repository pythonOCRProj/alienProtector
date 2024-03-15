<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <form action="NoticeWriteReg" method="post" enctype="multipart/form-data">
	<div>

		<div>
			<div>제목</div>
			<div>
				<input type="text" name="title" value="" />
					
			</div>
		</div>
		<div>
			<div>파일</div>
			<div>
				<input type="file" name="upfile" value="파일없음;" />
					
			</div>
		</div>


		<div >
			<div>내용</div>

			<div>
				<textarea name="content" rows="8" cols="168"></textarea>
			</div>
		</div>

		<div>
			<input type="button" value="목록보기" onclick="location.href='NoticeList'">
			<input type="submit" value="작성"/>
			 <input type="button" value="취소" onclick="location.href='NoticeList'">
			 
		</div>
	</div>	
</form> -->

<form action="NoticeWriteReg" method="post" enctype="multipart/form-data">
	<div class="noticeWrite">
		<div class="noticeWriteWrap">
			<div class="noticeWrite_titleWrap">
				<div class="noticeWrite_title">제목</div>
				<div>
					<input type="text" name="title" class="noticeContent_width" />
				</div>
			</div>
			<div class="noticeWrite_imgWrap">
				<div class="noticeWrite_title">첨부파일</div>
				<div>
					<input type="file" name="upfile" />
				</div>
			</div>
			<div class="noticeWrite_content">
				<div class="noticeWrite_title">내용</div>
				<div>
					<textarea name="content" cols="50" rows="20"
						class="noticeContent_width"></textarea>
				</div>
			</div>

			<div class="notice_underbar">
				<input type="button" value="목록보기"
					onclick="location.href='NoticeList'"> <input type="submit"
					value="작성" /> <input type="button" value="취소"
					onclick="location.href='NoticeList'">

			</div>
		</div>
		</div>
</form>
