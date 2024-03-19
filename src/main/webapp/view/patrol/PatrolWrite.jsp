<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>

<script src="../js/jquery-3.7.1.js"></script>
<script src="../js/clock.js"></script>
<script>
 $(function(){
    $("input[name='chk']").on("click",function(){
         if($(this).val()=='yes'){
             $("textarea[name='special']").attr("readonly",false).val("")
         }
         else{
            $("textarea[name='special']").attr("readonly",true).val("특이사항 없음")
         }
      })
      
    $(".patrol_turnbox:nth-of-type(1)").on("click",function(){
    	location.href="PatrolWrite?click=1";
    })
     $(".patrol_turnbox:nth-of-type(2)").on("click",function(){
    	 location.href="PatrolWrite?click=2";
    })
     $(".patrol_turnbox:nth-of-type(3)").on("click",function(){
    	 location.href="PatrolWrite?click=3";
    })
 })
</script>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="PatrolReg" method="post" enctype="multipart/form-data">
   <div class="patrol">
      <div class="patrol_timebox">
      	<div class="patrol_time" id="clock"></div>
       	<div class="patrol_day">${day }</div>
      </div>
      <div class="patrol_turn">
      <c:forEach items="${turn}" var="turn" varStatus="i">
      <div class="patrol_turnbox">
         <div class="patrol_title">${i.index+1 } 회차</div>

         <div class="patrol_turnChk">
            <div>
               <c:choose>
               <c:when test="${turn }">
                  <img src="../img/check.png">
               </c:when>
               <c:otherwise></c:otherwise>
               </c:choose>
            </div>
         </div>
         </div>
         </c:forEach>
      
      </div>
      <div class="patrol_file">
      <c:forEach items="${place }" var="pla">
         <div class="patrol_box">
            <div class="patrol_position">${pla.position }</div>
            <c:forEach items="${data }" var="da">
            	<c:choose>
            		<c:when test="${pla.position == da.position }">
            		<div class="patrol_now">
						<div class="patrol_nowsub"><b>촬영 시간</b></div> <div class="patrol_nowtime">${da.time } </div>
						<div class="patrol_nowsub"><b>등록 시간</b></div> <div class="patrol_nowtime">${da.nowStr }</div> 
					</div>	
            		</c:when>
            		<c:otherwise>
            		</c:otherwise>
            	</c:choose>
            </c:forEach>
         </div>
         </c:forEach>
      </div>
      <div class="patrol_btn">
          <input type="file"  name="photo">
      </div>
      <div class="patrol_special">
         <div class="patrol_radio">
         	<div class="patrol_spectitle">특이사항</div>
         	<div class="patrol_radioselect">
            	<input type="radio" name="chk" value="no" checked>없음
            	<input type="radio" name="chk" value="yes">있음
         	</div>
         </div>
         <div class="patrol_text">
            <textarea name="special" readonly="readonly" >특이사항 없음</textarea>
         </div>
      </div>
         <div class="patrol_submit">
            <input type="submit" class="btn" id="sumitBtn" value="등록">
         </div>
   </div>
</form>
</body>
</html>