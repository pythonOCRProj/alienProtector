<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

</script>
	<form action="WorkerJoinReg" method="post" enctype="multipart/form-data">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" Placeholder="아이디를 입력해 주세요">
					<input type="button" name="idcheck" value="중복확인">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" Placeholder="비밀번호를 입력해 주세요"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pwdchk" Placeholder="비밀번호와 같은 값을 입력해주세요"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input class="select_email" name="email" type="text" />@
					<input class="select_email" name="email2" />
					<select name="email3">
						<option value="type">직접입력</option>
						<option value="google.com">google.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
						<option value="daum.net">daum.net</option>
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
				<td colspan="2">
					<input type="text" 	name="addr" id="sample6_postcode" 		placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	
					<input type="text" 	name="addr" id="sample6_address" 		placeholder="주소"><br>
				
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
				<td>
					<input type="submit" value="등록" />
				</td>
				<td>
					<input type="button" value="취소" onClick="location.href='<c:url value="/worker/WorkerList" />' " />
				</td>
			</tr>
		</table>
	</form>
