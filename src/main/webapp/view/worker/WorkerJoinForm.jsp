<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="<c:url value='/js/address.js' />"></script>
	<!-- name="userInfo" -->
	<form action="WorkerJoinComple" onsubmit="return checkValue()" method="post">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<!-- 중복체크후 아이디못바꾸게하기 onkeydown -->
					<input type="text" name="id" onkeydown="inputIdChk()">
					<!-- 중복확인 클릭시 중복확인창 띄움 -->
					<input type="button" value="중복확인" onclick="openIdChk()" >
					<!-- 중복체크 판단여부 -->
					<input type="hidden" name="idDuplication" value="idUncheck">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type="password" name="passwordcheck">
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" />
					<select name="email2">
						<option>naver.com</option>
						<option>daum.net</option>
						<option>gmail.com</option>
						<option>nate.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td>
					<input type="text" name="phone_num" />
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" />
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
				<td>프로필사진</td>
				<td><input type="text" name="profile_img" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록" />
					<a href='<c:url value="/worker/WorkerList" />'>이전화면</a>
				</td>
			</tr>
		</table>
	</form>
