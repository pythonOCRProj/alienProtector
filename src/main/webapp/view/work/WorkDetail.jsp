<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.workDetailBox{
		margin: 1rem;
		
	}
	.workDetailBox div {
		border: 1px solid gray;
	}
</style>
    
<div class="workDetailBox">
	<a href="javascript:window.history.back();">뒤로가기</a>
	<div class="workDetailTitle">
		<div><span>근무조</span> | <b>${workDetail.shift }</b></div>
		<div><span>근무지역</span> | <b>${workDetail.position }</b></div>
		<div><span>날짜</span> | <b>${workDetail.date }</b></div>
		<div><span>시간</span> | <b>${workDetail.time }</b></div>
		<div><span>근무자</span> | <b>${workDetail.name }(${workDetail.id })</b></div>

	</div>
	<div class="workDetailContent">
		<img src="/alienProtector/img/${workDetail.photo }" alt="${workDetail.position } 사진">
		<p>${workDetail.special }</p>
	</div>
</div>