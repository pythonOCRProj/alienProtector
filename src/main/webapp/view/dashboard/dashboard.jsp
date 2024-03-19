<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/clock.js"></script>


<div class="dashboard__clock">
	<div class="dashboard__date">${clockDate }</div>
	<div class="dashboard__time" id="clock"></div>
</div>
<div class="flexBox col2">
	<div class="dashboard__tableBox goTable">
		<h3>출근한 근무자</h3>
		<table border="">
			<colgroup>
				<col style="width: 30%; max-width:180px;">
	 			<col style="width: 70%; min-width:160px">
	
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
	</div>
	<div class="dashboard__tableBox leaveTable">
		<h3>퇴근한 근무자</h3>
		<table border="">
			<colgroup>
				<col style="width: 22%; max-width: 180px;">
	 			<col style="width: 39%; min-width:160px">
	 			<col style="width: 39%; min-width:160px">
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
	</div>
</div>


<div class="dashboard__tableBox">
	<h3>당일 순찰 상태</h3>
	<a href="<c:url value="/work/WorkList"/>" class="dashboard__link">근무일지 더보기 >></a>
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
</div>