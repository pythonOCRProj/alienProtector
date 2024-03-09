
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>


</style>

<script>
function fileDel(){
	
	if(confirm("파일을 삭제하시겠습니까?\n삭제된파일은 복구불가입니다.")){
	var frm =document.frm;
	frm.action = "FileDelete"
	frm.submit()
	}
}
</script>

<form name="frm" action="NoticeModifyReg" method="post" >
	<div>
	
		<div>
			<div>제목</div>
			<div>
				<input type="text" name="title"
					value="디테일에서받아오는제목값" />
			</div>
		</div>
		<div>
			<div>파일</div>
			<div>
				<c:choose>
					<c:when test="${dto.upfile!=null }">
						<input type="text" name="upfile" value="${dto.upfile }" readonly="readonly"/>
						<input type="button" onclick="fileDel()" value="파일삭제" />
					</c:when>
					<c:otherwise>
						<input type="file" name="upfile" />	
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>

		<div>
			<div>내용</div>
			
			<div>
				<textarea name="content" rows="8" cols="168">디테일에서받아오는 내용값</textarea>
			</div>
		</div>
		<div>
		<input type="submit" value="수정"/>	 <a href="NoticeList" >취소</a>
		</div>
	</div>
</form>