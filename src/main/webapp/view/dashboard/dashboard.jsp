<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<section class="master">
	<h3>출근한 근무자</h3>
	<table border="">
		<colgroup>
			<col style="width: 22%">
 			<col style="width: 78%">

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
		 			<td>${tg.name }(${tg.id })</td>
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
 			<col style="width: 39%">
 			<col style="width: 39%">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">근무자</th>
				<th scope="col">출근시간</th>
				<th scope="col">퇴근시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todayLeave }" var="tl">
				<tr>
		 			<td>${tl.name }(${tl.id })</td>
		 			<td>${tl.goTimeStr }</td>
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
				<th scope="col">회차</th>
				<th scope="col">순찰구역</th>
				<th scope="col">특이사항</th>
				<th scope="col">시간</th>
				<th scope="col">근무자</th>
			</tr>
		</thead>
		<tbody>	
			<c:forEach items="${todayPatrol }" var="tp">
				<tr>
					<td>${tp.shift }</td>
					<td>${tp.turn }</td>
					<td>${tp.position }</td>
					<td>${tp.special }</td>
			 		<td>${tp.time }</td>
		 			<td>${tp.name }(${tp.id })</td>
		 		</tr>
			</c:forEach>

		</tbody>
	</table>
</section>