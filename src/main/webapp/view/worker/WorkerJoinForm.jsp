<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<form action="WorkerJoinFormReg" method="post" enctype="multipart/form-data">
		<table border="">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" Placeholder="아이디를 입력해 주세요">
				</td>
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
				<td >
					<input type="text" name="addr" />
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
