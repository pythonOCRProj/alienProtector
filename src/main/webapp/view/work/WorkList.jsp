<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sortList">
	<a href="#">근무지역</a>
	<a href="#">근무자</a>	
</div>
<section>
	<div class="workDateBox">
	<c:forEach items="${dateArr }" var="da" >
		<div class="workDate">
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
 					<c:forEach items="${workArr }" var="wa">
 					<c:if test="${da.date == wa.date }">
 					
						<tr>
							<td>오전</td>
							<td>${wa.position }</td>
				 			<td>${wa.id }</td>
							<td>${wa.special }</td>
					 		<td>09:30:23</td>
				 		</tr>
 					</c:if>
					</c:forEach>
		
				</tbody>
			</table>
		</div>
	</c:forEach>

	</div>
</section>