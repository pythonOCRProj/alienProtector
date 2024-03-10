<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="PatrolReg">
	<div class="big">
		<div class="box">
			<div class="positon">
				<div>101호</div>
			</div>
			<div class="positon">
				<div>101호</div>
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
			<div class="positon">
				<div>확인표시넣을겨</div>
			</div>
			<div class="positon">
				<div>확인표시넣을겨</div>
			</div>
			<div class="positon">
			<div>확인표시넣을겨</div>
			</div>
			<div class="positon">
				<div>확인표시넣을겨</div>
			</div>
			<div class="positon">
				<div>확인표시넣을겨</div>
			</div>
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