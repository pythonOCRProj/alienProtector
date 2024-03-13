<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<form action="WorkerJoinComple" method="post" enctype="multipart/form-data">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" />
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
					<input type="text" name="addr" />
				</td>
			</tr>
			<tr>
				<td>프로필사진</td>
				<td>
					<td><input type="file" name="profile_img" size="200" /></td>
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
