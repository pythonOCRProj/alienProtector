<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<style>
	*{
		margin:0;
		padding:0;
	}
	.big{
		width:1200px; 
		height:1000px; 
		border:1px solid #000; 
		
	}
	.box{
		margin-left:200px;
		margin-top:100px;
		border:1px solid #f0f;
		width:800px;
		height:200px;
	
	}
	.positon{
		width:150px;
		height:100px;
		border:1px solid #0ff;
		float:left;
	}
	
</style>
<script src="../js/jquery-3.7.1.js"></script>
<script>
 $(function(){
	 $("input[name='chk']").on("click",function(){
			if($(this).val()=='yes'){
			 	$("textarea[name='special']").attr("readonly",false).val("")
			}
			else{
				$("textarea[name='special']").attr("readonly",true).val("특이사항 없음")
			}
		}) 
 })
	
	
</script>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="PatrolReg" method="post" enctype="multipart/form-data">
	<div class="big">
		<div class="box">
			<div class="positon">
				<div>101호</div>
			</div>
			<div class="positon">
				<div>102호</div>
			</div>
			<div class="positon">
				<div>103호</div>
			</div>
			<div class="positon">
				<div>104호</div>
			</div>
			<div class="positon">
				<div>105호</div>
			</div>
			<c:forEach items="${pos}" var="pos">
			<div class="positon">
				<div>
					<c:choose>
					<c:when test="${pos }">
						확인 완료
					</c:when>
					<c:otherwise>
						미등록
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
		</div>
		<div class="box">
			<div>
				<input type="file" name="photo">
			</div>
		</div>
		<div class="box">
			<div>특이사항
				<input type="radio" name="chk" value="no" checked>없음
				<input type="radio" name="chk" value="yes">있음
			</div>
			<div>
				<textarea rows="5" cols="100" name="special" readonly="readonly" >특이사항 없음</textarea>
			</div>
			<div>
				<input type="submit" value="등록">
			</div>
		</div>
	</div>
</form>
</body>
</html>