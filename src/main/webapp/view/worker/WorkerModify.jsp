<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 전송 버튼 및 비밀번호, 휴대폰 번호 수정할 수 있게 변경 -->

<form action="WorkerModifyReg">
	<div class = "worker">
		<div class="worker__img">
			<!-- 이미지 있을 유무 -->
			<c:if test="${dto.profileImg == null }">
				<img src="../profile/" alt="" />
			</c:if>
			
			<c:if test="${dto.profileImg != null }">
				<img src="../profile/${dto.profileImg}" alt="" />
			</c:if>
		</div>
		<div class="worker__row">
			<div class="worker__col">
				<p>아이디 : ${dto.id} - 
					<c:choose>
						<c:when test="${dto.hire == 0 }">
							[ 퇴사자 ]
						</c:when>
						<c:otherwise>
							[ 재직자 ]
						</c:otherwise>
					</c:choose>
				</p>
				<c:choose>
					<c:when test="${dto.hire == 1 }">
						<button>퇴사</button>
					</c:when>
					<c:otherwise>
						<button>재입사</button>
					</c:otherwise>
				</c:choose>
			</div>		
			<p>입사일 : ${dto.joinDate}</p>
		</div>
		<div class="worker__row">
			<p>이름 : ${dto.phone_num}</p>
			<p>주소 : ${dto.addr}</p>
		</div>
		<div class="worker__row">
			<p>연락 번호 : ${dto.phone_num}</p>
			<p>이메일 : ${dto.email}</p>
		</div>
		<div class="worker__btns">
			<input type="submit" value= "전송"/>
			<button>목록</button>
			
		</div>
	</div>
</form>



    

    