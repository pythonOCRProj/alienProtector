<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="master">
	<h3>출근한 근무자</h3>
	<table border="">
		<colgroup>
			<col style="width: 22%">
 			<col style="width: 78%;">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">근무자</th>
				<th scope="col">출근시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todayGo }" var="tg">
				<tr>
		 			<td>${tg.id }</td>
		 			<td>${tg.goTimeStr }</td>
		 		</tr>
			</c:forEach>	

		</tbody>
	</table>
</section>
<section class="master">
	<h3>퇴근한 근무자</h3>
	<table border="">
		<colgroup>
			<col style="width: 22%">
 			<col style="width: 78%;">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">근무자</th>
				<th scope="col">퇴근시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todayLeave }" var="tl">
				<tr>
		 			<td>${tl.id }</td>
		 			<td>${tl.leaveTimeStr }</td>
		 		</tr>
			</c:forEach>	

		</tbody>
	</table>
</section>

<section class="master">
	<h3>당일 순찰 상태</h3>
	<table border="">
		<colgroup>
<%-- 			<col style="width: 78%;">
			<col style="width: 22%"> --%>
		</colgroup>
		<thead>
			<tr>
				<th scope="col">근무조</th>
				<th scope="col">근무지역</th>
				<th scope="col">근무자</th>
				<th scope="col">특이사항</th>
				<th scope="col">시간</th>
			</tr>
		</thead>
		<tbody>	
			<c:forEach items="${todayPatrol }" var="tp">
				<tr>
					<td>오전</td>
					<td>${tp.position }</td>
		 			<td>${tp.id }</td>
					<td>${tp.special }</td>
			 		<td>${tp.time }</td>
		 		</tr>
			</c:forEach>

		</tbody>
	</table>
</section>