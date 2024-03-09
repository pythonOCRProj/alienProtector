<style>
.SlaveBoard__listinfo{
	width: 1200px;
	
		margin :10px;
	display: flex;
}
.Notice__box{
	width: 1200px;
}
.Notice__listWrap{
	width: 1200px;
	border: 1px solid rgb(192, 192, 192);
	margin :10px 0px 0px 0px;
}
.Notice__info{
	display: flex;
	margin :5px 5px 5px 730px;
}


</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="Notice__box">
		<div class="Notice__listWrap">
			<div class="Notice__listinfo">
			
					<div><a href="NoticeDetail?no=3&nowPage=3">첫번째 공지사항 안내드립니다 !!!</a></div>
					
					<div class="Notice__info">
				
				<div> 2024-03-08 </div> 
				<div> 조회수 1 </div>
			</div>
		</div>	
</div>

<input type="button" value="글쓰기" onclick="location.href='NoticeWrite'">
		