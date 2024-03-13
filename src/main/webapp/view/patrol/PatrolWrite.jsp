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
		max_width:360px;
		width:100%; 
		display:flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	.time{
		margin-top:50px;
		width:95%;
		border:1px solid #f0f;
		height:150px;
	}
	 .turn{
	 	max_hight:100px;
		margin-top:50px;
		width:95%;
		border:1px solid #f0f;
		height:100px;
	 }
	.info{
		width:22%;
		height:100%;
		border:1px solid #0ff;
		float:left;
	}
	.turnChk{
		width:26%;
		height:100%;
		border:1px solid #0ff;
		float:left;
	}
	.box{
		margin-top:50px;
		width:95%;
		border:1px solid #f0f;
		height:750px;
	}
	.positon{
		width:100%;
		height:150px;
		border:1px solid #0ff;
	
	}
	.po{
		width:25%;
		height:150px;
		border:1px solid #0ff;
		float:left;
	}
	.po_time{
		width:75%;
		height:150px;
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
		<div class="time">
			<h1>시간</h1>
		</div>
		<div class="turn">
			<div class="info">회차</div>
			<c:forEach items="${turn}" var="turn">
			<div class="turnChk">
				<div>
					<c:choose>
					<c:when test="${turn }">
						<img src="../img/check.png">
					</c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
				</div>
			</div>
			</c:forEach>
		
		</div>
		<div class="box">
			<div class="positon">
				<div class="po">101호</div>
				<div class="po_time">102호</div>
			</div>
			<div class="positon">
				<div class="po">101호</div>
				<div class="po_time">102호</div>
			</div>
			<div class="positon">
				<div class="po">101호</div>
				<div class="po_time">102호</div>
			</div>
			<div class="positon">
				<div class="po">101호</div>
				<div class="po_time">102호</div>
			</div>
			<div class="positon">
				<div class="po">101호</div>
				<div class="po_time">102호</div>
			</div>
			<c:forEach items="${pos}" var="pos">
			<div class="zz">
				<div class="chk_${pos }">
					<c:choose>
					<c:when test="${pos }">
						<img src="../img/check.png">
					</c:when>
					<c:otherwise>
				
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