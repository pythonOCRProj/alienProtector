<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function idCheck(){
	  //새창 만들기
	  window.open("IdCheckForm", "idchang", "width=400, height=350");
	}
</script>
	<form action="WorkerJoinFormReg" method="post" name="parform" enctype="multipart/form-data">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" Placeholder="아이디를 입력해 주세요" onkeydown="inputIdChk()">
					<input type="button" value="ID중복확인" onclick="idCheck()">
				</td>
				<!-- 중복 체크 여부 
				<input type="hidden" name="idcheck" value="iduncheck" />
				-->
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
					<input type="text" name="phone_num" Placeholder="-는 제외하고 숫자만 입력해주세요" />
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
					<input type="submit" value="등록" />
				</td>
				<td>
					<input type="button" value="취소" onClick="location.href='<c:url value="/worker/WorkerList" />' " />
				</td>
			</tr>
		</table>
	</form>
