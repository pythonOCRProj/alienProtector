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
			<input class="upload-profile" type="file" name="profile"/>
		</div>
		<div class="worker__rows">
			<div class="worker__row">
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
				<input type="hidden" name="id" value="${dto.id }" />																		
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
				<input type="text" name="email" placeholder="이메일 입력 ex) worker@exam.com" value="${dto.email}" />
			</div>
		</div>
		<div class="worker__btns">
			<input class="worker__sum-btn" type="submit" value= "전송"/>
			<input class="worker__sum-btn worker__basic-btn" type="button" value= "목록"/>
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
		
		$(".worker__btns > input[type=button]").on("click",function(e){
			location.href="/alienProtector/worker/WorkerList";
		});
		
		
		$(".worker__img > img").on("keydown",function(e){
			let upload = $(".upload-profile")
			upload.click();
		});
		
		$("input[name = pwd]").on("keydown",function(e){
			if(e.key == "Enter"){			
				e.preventDefault();
				$("input[name=pwdChk]").focus();
			}
		});
		$("input[name = pwdChk]").on("keydown",function(e){
			if(e.key == "Enter"){			
				e.preventDefault();
				$("input[name=phone]").focus();
			}
		});
		$("input[name = phone]").on("keydown",function(e){
			if(e.key == "Enter"){			
				e.preventDefault();
				$("input[name=email]").focus();
			}
		});
		
		$("input[name = email]").on("keydown",function(e){
			if(e.key == "Enter"){			
				e.preventDefault();
				$("input[type=submit]").focus();
			}
		});
		
	})

</script>


    

    