<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	window.onload = function(){
		sort()
		
		accordian()
	}
	function sort(){			
		var sortOn = '${params.sort}';
		var sortOnTarget = document.getElementById(sortOn+'Sort');
		if(sortOn == null){
			sortOn = 'shift';
		}
/* 		console.log(sortOn)
		console.log(sortOnTarget) */
		sortOnTarget.classList.add('active')		
	}
	
	
    function accordian() {
        $('.workList .workListTitle').click(function () {

          $(this).parent('.workList').toggleClass('active');
          $(this).siblings(".workTable").stop().slideToggle(300);
/*            $('.workList .workListTitle').not(this).siblings(".workTable").stop().slideUp(300);
          $('.workList .workListTitle').not(this).parent('.workList').removeClass('active');  */
        });
      }	
</script>

<section class="workSection">
<div class="sortList">
	<a href="<c:url value="/work/WorkList"/>" id="shiftSort">근무조</a>
	<a href="<c:url value="/work/WorkList?sort=position"/>" id="positionSort">순찰구역</a>
	<a href="<c:url value="/work/WorkList?sort=worker"/>" id="workerSort">근무자</a>
</div>
<form action="" >
	<div class="dateBox">
		<input type="hidden" name="sort" value="${params.sort }"/>
		<input type="date" name="start" id="startDate" value="${params.start }"> ~ <input type="date" name="end" id="endDate"value="${params.end }">
		<input type="submit" value="조회" class="btn"/>
	</div>
</form>
	<div class="workListBox">
	<c:if test="${param.sort == null || param.sort == 'shift'}">
		<h3>근무조</h3>
		<c:forEach items="${shiftList }" var="sl" >

			<div class="workList">
				<div class="workListTitle">
					<h4>${sl.shift }</h4>
				</div>
				<div class="workTable">
					<table border="">
						<colgroup>
				<%-- 			<col style="width: 78%;">
							<col style="width: 22%"> --%>
						</colgroup>
						<thead>
							<tr>
								<th scope="col">회차</th>
								<th scope="col">순찰구역</th>
								<th scope="col">특이사항</th>
								<th scope="col">날짜</th>
								<th scope="col">시간</th>
								<th scope="col">근무자</th>
							</tr>
						</thead>
						<tbody>	
		 					<c:forEach items="${workData }" var="wd">
		 					<c:if test="${sl.shift == wd.shift }">
								<tr onclick="location.href='<c:url value="/work/WorkDetail?no=${wd.no }" />'" style="cursor:pointer;">
									<td>${wd.turn }</td>
									<td>${wd.position }</td>
									<td>${wd.special }</td>
									<td>${wd.date }</td>
							 		<td>${wd.time }</td>
						 			<td>${wd.name }(${wd.id })</td>
						 		</tr>
		 					</c:if>
							</c:forEach>
				
						</tbody>
					</table>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${param.sort == 'position' }">
		<h3>순찰구역</h3>
		<c:forEach items="${placeList }" var="pl" >
			<div class="workList">
				<div class="workListTitle">
					<h4>${pl.position }</h4>
				</div>
				<div class="workTable">
	 				<table border="">
						<colgroup>
						</colgroup>
						<thead>
							<tr>
								<th scope="col">근무조</th>
								<th scope="col">회차</th>
								<th scope="col">특이사항</th>
								<th scope="col">날짜</th>
								<th scope="col">시간</th>
								<th scope="col">근무자</th>
							</tr>
						</thead>
						<tbody>	
		 					<c:forEach items="${workData }" var="wd">
		 					<c:if test="${pl.position == wd.position }">
		 					
								<tr onclick="location.href='<c:url value="/work/WorkDetail?no=${wd.no }" />'" style="cursor:pointer;">
									<td>${wd.shift }</td>
									<td>${wd.turn }</td>
									<td>${wd.special }</td>
									<td>${wd.date }</td>
							 		<td>${wd.time }</td>
									<td>${wd.name }(${wd.id })</td>
						 		</tr>
		 					</c:if>
							</c:forEach>
				
						</tbody>
					</table>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${param.sort == 'worker'}">
	<h3>근무자 - 재직자</h3>
		<c:forEach items="${workerList }" var="wl" >
			<c:if test="${wl.hire == 1 }">
				<div class="workList">
					<div class="workListTitle">
						<h4>${wl.name } (${wl.id })</h4>
					</div>
					<div class="workTable">
		 				<table border="">
							<colgroup>
							</colgroup>
							<thead>
								<tr>
									<th scope="col">근무조</th>
									<th scope="col">회차</th>
									<th scope="col">순찰구역</th>
									<th scope="col">특이사항</th>
									<th scope="col">날짜</th>
									<th scope="col">시간</th>
								</tr>
							</thead>
							<tbody>	
			 					<c:forEach items="${workData }" var="wd">
			 					<c:if test="${wl.id == wd.id }">		 					
									<tr onclick="location.href='<c:url value="/work/WorkDetail?no=${wd.no }" />'" style="cursor:pointer;">
										<td>${wd.shift }</td>
										<td>${wd.turn }</td>
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
				</div>
			</c:if>
		</c:forEach>
		<h3>근무자 - 퇴직자</h3>
		<c:forEach items="${workerList }" var="wl" >
			<c:if test="${wl.hire == 0 }">
				<div class="workList">
					<div class="workListTitle">
						<h4>${wl.name } (${wl.id })</h4>
					</div>
					<div class="workTable">
		 				<table border="">
							<colgroup>
							</colgroup>
							<thead>
								<tr>
									<th scope="col">근무조</th>
									<th scope="col">회차</th>
									<th scope="col">순찰구역</th>
									<th scope="col">특이사항</th>
									<th scope="col">날짜</th>
									<th scope="col">시간</th>
								</tr>
							</thead>
							<tbody>	
			 					<c:forEach items="${workData }" var="wd">
			 					<c:if test="${wl.id == wd.id }">		 					
									<tr onclick="location.href='<c:url value="/work/WorkDetail?no=${wd.no }" />'" style="cursor:pointer;">
										<td>${wd.shift }</td>
										<td>${wd.turn }</td>
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
				</div>
			</c:if>
		</c:forEach>
	</c:if>

	</div>
</section>