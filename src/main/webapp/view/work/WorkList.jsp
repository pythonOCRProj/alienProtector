<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sortList">
	<a href="<c:url value="/work/WorkList"/>">시간순</a>
	<a href="<c:url value="/work/WorkList?sort=position"/>">근무지역</a>
	<a href="<c:url value="/work/WorkList?sort=worker"/>">근무자</a>	
</div>
<section>
	<div class="workListBox">
	<c:if test="${param.sort == null }">
		<c:forEach items="${dateArr }" var="da" >

			<div class="workList">
				<h4>${da.date }</h4>
				<table>
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
	 					<c:forEach items="${workData }" var="wd">
	 					<c:if test="${da.date == wd.date }">
	 					
							<tr>
								<td>오전</td>
								<td>${wd.position }</td>
					 			<td>${wd.id }</td>
								<td>${wd.special }</td>
						 		<td>${wd.time }</td>
					 		</tr>
	 					</c:if>
						</c:forEach>
			
					</tbody>
				</table>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${param.sort == 'position' }">
		<c:forEach items="${placeList }" var="pl" >
			<div class="workList">
				<h4>${pl.position }</h4>
 				<table>
					<colgroup>
					</colgroup>
					<thead>
						<tr>
							<th scope="col">근무조</th>
							<th scope="col">특이사항</th>
							<th scope="col">날짜</th>
							<th scope="col">시간</th>
						</tr>
					</thead>
					<tbody>	
	 					<c:forEach items="${workData }" var="wd">
	 					<c:if test="${pl.position == wd.position }">
	 					
							<tr>
								<td>오전</td>
								<td>${wd.special }</td>
								<td>${wd.date }</td>
						 		<td>${wd.time }</td>
					 		</tr>
	 					</c:if>
						</c:forEach>
			
					</tbody>
				</table>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${param.sort == 'worker' }">
		<c:forEach items="${workerList }" var="wl" >
			<c:if test="${wl.id != 'master' }">
			<div class="workList">
				<h4>${wl.name } (${wl.id })</h4>
 				<table>
					<colgroup>
					</colgroup>
					<thead>
						<tr>
							<th scope="col">근무조</th>
							<th scope="col">근무지역</th>
							<th scope="col">특이사항</th>
							<th scope="col">날짜</th>
							<th scope="col">시간</th>
						</tr>
					</thead>
					<tbody>	
	 					<c:forEach items="${workData }" var="wd">
	 					<c:if test="${wl.id == wd.id }">
	 					
							<tr>
								<td>오전</td>
								<td>${wd.position }</td>
								<td>${wd.special }</td>
								<td>${wd.date }</td>
						 		<td>${wd.time }</td>
					 		</tr>
	 					</c:if>
						</c:forEach>
			
					</tbody>
				</table>
			</div>
			</c:if>
		</c:forEach>
	</c:if>

	</div>
</section>