<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
const autoHyphen = (target) => {
    target.value = target.value
     .replace(/[^0-9]/g, '')
     .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

function idCheck(){
	  //새창 만들기
	  window.open("IdCheckForm", "idchang", "width=400, height=350");
}

function checkValue() {
	 
	//var form = document.parform;
	
	
	if(document.parform.idDuplication.value != "idCheck" ) {
		alert("아이디 중복체크를해주세요.")
		return false;
	} 
	//else {
	//	alert("통과")
	//}
	
}

function inputIdChk() {
	document.parform.idDuplication.value ="idUncheck";
}
</script>
	<form action="WorkerJoinFormReg" method="post" name="parform" enctype="multipart/form-data" onsubmit="return checkValue()">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" Placeholder="아이디를 입력해 주세요" onkeydown="inputIdChk()">
					<input type="button" value="ID중복확인" onclick="idCheck()">
					<input type="hidden"  name="idDuplication"  value="idUnCheck">
				</td>
				<!--  중복 체크 여부  -->
				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" Placeholder="비밀번호를 입력해주세요"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pwdchk" Placeholder="비밀번호와 같은 값을 입력해주세요"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td>
					<input type="text" name="phone_num" oninput="autoHyphen(this)"  maxlength="13"  Placeholder="000-0000-0000" />
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" Placeholder="한글만 2~4글자 입력해주세요" />
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" 	name="addr1" id="sample6_postcode" 		placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	
					<input type="text" 	name="addr2" id="sample6_address" 		placeholder="주소"><br>
				
					<input type="text" 	name="addr3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text"  name="addr4" id="sample6_extraAddress"  placeholder="참고항목">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록"  />
				</td>
				<td>
					<input type="button" value="취소" onClick="location.href='<c:url value="/worker/WorkerList" />' " />
				</td>
			</tr>
		</table>
	</form>
