
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
table {
    width: 100%;
    border: 1px solid #444444;
  }
th {
	 background-color: green;
} 
  
td{
    border: 1px solid #444444;
  
}

tr:nth-child(2n+0){background-color: tomato;}
</style>
<table class="workerlist">
	<tr>
	    <th>번호</th>
		<c:forTokens items="아이디,등록일,이메일,휴대폰번호,이름,주소" delims="," var="tt">
			<th>${tt }</th>
		</c:forTokens>
	</tr>
	<c:forEach items="${mainData}" var="dto" varStatus="no" >
	<tr>
	    <td>${no.index+1}</td>
		<td><a href='<c:url value="/worker/WorkerModify?id=${ dto.id }"/>' >${dto.id }</a></td>
		<td>${dto.joinDate }</td>
		<td>${dto.email }</td>
		<td>${dto.phoneNum }</td>
		<td>${dto.name }</td>
		<td>${dto.addr }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7">
			<a href='<c:url value="/worker/WorkerJoinForm" />'>근로자등록</a>		
		</td>
	</tr>	
</table>
