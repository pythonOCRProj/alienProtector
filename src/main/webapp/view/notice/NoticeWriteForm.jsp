<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="NoticeWriteReg" method="post" enctype="multipart/form-data">
	<div>

		<div>
			<div>제목</div>
			<div>
				<input type="text" name="title"
					value="" />
			</div>
		</div>
		<!-- <div>
			<div>파일</div>
			<div>
				<input type="file" name="upfile"
					value="파일없음;" />
			</div>
		</div> -->

		<div >
			<div>내용</div>

			<div>
				<textarea name="content" rows="8" cols="168"></textarea>
			</div>
		</div>

		<div>
			<input type="button" value="목록보기" onclick="location.href='NoticeList'">
			<input type="submit" value="작성"/>
			 <a href="NoticeList">취소</a>
			 
		</div>
	</div>	
</form>