<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 전송 버튼 및 비밀번호, 휴대폰 번호 수정할 수 있게 변경 -->
<form action="WorkerModifyReg" method="post" enctype="multipart/form-data">
	<div class = "worker">
		<div class="worker__img">
			<!-- 이미지 있을 유무 -->
			<c:if test="${dto.profileImg == null }">
				<img src="../profile/user.png" alt="" />
			</c:if>
			
			<c:if test="${dto.profileImg != null }">
				<img src="../profile/${dto.profileImg}" alt="" />
			</c:if>
			<input type="file" name="profile"/>
		</div>
		<div class="worker__rows">
			<div class="worker__row">
				<input type="hidden" name="id" value="${dto.id }" />

				<p class="worker__col">아이디</p>
				<div class="worker__col">
					${dto.id} - 
						<c:choose>
							<c:when test="${dto.hire == 0 }">
								[ 퇴사자 ]
							</c:when>
							<c:otherwise>
								[ 재직자 ]
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${dto.hire == 1 && dto.id != 'master' }">
								<button class="retire">퇴사</button>
							</c:when>
							<c:when test="${dto.hire == 0 && dto.id != 'master' }">
								<button class="rework">재입사</button>
							</c:when>
							
						</c:choose>
				</div>																		
			</div>
			
			<div class="worker__row">
				<p class="worker__col">입사일</p>
				<p class="worker__col">${dto.joinDate}</p>
			</div>
			
		</div>
		<div class="worker__rows">
			<div class="worker__row">
				<input type="text" name="pwd" placeholder="비밀번호" />
			</div>
			<div class="worker__row">
				<input type="text" name="pwdChk" placeholder="비밀번호 확인" />
			</div>
		</div>
		<div class="worker__rows">
			<div class="worker__row">
				<p class="worker__col">이름</p>
				<p class="worker__col">${dto.name}</p>
			</div>
			<div class="worker__row">
				<p class="worker__col">주소</p>
				<p class="worker__col">${dto.addr }</p>
			</div>
		</div>
		<div class="worker__rows">
			<div class="worker__row">
				<input type="text" name="phone" placeholder="ex) 010-1234-1234" value="${dto.phoneNum}" />
			</div>
			<div class="worker__row">
				<p class="worker__col">이메일</p>
				<p class="worker__col">${dto.email }</p>
			</div>
		</div>
		<div class="worker__btns">
			<input class="worker__sum-btn" type="submit" value= "전송"/>
			<a class="worker__sum-btn worker__basic-btn" href="/alienProtector/worker/WorkerList">목록</a>
		</div>
	</div>
</form>

<script>
	$(()=>{
		$(".worker__col > button").on("click",function(e){
			e.preventDefault();
			const html = $(this).html();
			if(confirm("정말로 "+html+" 시키겠습니까?")){				
				window.location.href = "/alienProtector/worker/Returning?id=${dto.id}&s="+html
			}
			
		});
		
	})

</script>


    

    