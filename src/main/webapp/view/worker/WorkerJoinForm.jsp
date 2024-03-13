<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

</script>
	<form action="WorkerJoinComple" method="post" enctype="multipart/form-data">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" Placeholder="아이디를 입력해 주세요">
				</td>
				<td><input type="button" name="idcheck" value="중복확인"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" />
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td colspan="2">
					<input type="text" name="phone_num" />
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="2">
					<input type="text" name="name" />
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td colspan="2">
					<input type="text" 	name="addr" id="sample6_postcode" 		placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">
					<input type="text" 	name="addr" id="sample6_address" 		placeholder="주소">
				
					<input type="text" 	name="addr" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text"  name="addr" id="sample6_extraAddress"  placeholder="참고항목">
				</td>
			</tr>
			<tr>
				<td>프로필사진</td>
				<td>
					<input type="file" name="profile_img" size="200" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록" />
					<a href='<c:url value="/worker/WorkerList" />'>이전화면</a>
				</td>
			</tr>
		</table>
	</form>
