<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>

<script src="../js/jquery-3.7.1.js"></script>
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
 })
   
   
</script>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="PatrolReg" method="post" enctype="multipart/form-data">
   <div class="patrol">
      <div class="patrol_time">
         <h1>시간</h1>
      </div>
      <div class="patrol_turn">
         <div class="patrol_title">회차</div>
         <c:forEach items="${turn}" var="turn">
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
         </c:forEach>
      
      </div>
      <div class="patrol_file">
      <c:forEach items="${place }" var="ppp">
         <div class="patrol_box">
            <div class="patrol_position">${ppp.position }</div>
            <c:forEach items="${data }" var="ddd">
            	<c:choose>
            		<c:when test="${ppp.position == ddd.position }">
						야야야야야야야야야          
            		</c:when>
            		<c:otherwise>
            			웅오ㅗㅇㄴㅇ몽놩
            		</c:otherwise>
            	</c:choose>
            </c:forEach>
           
         </div>
         </c:forEach>
        
      </div>
      <div class="box">
         <div>
            <input type="file" name="photo">
         </div>
      </div>
      <div class="box">
         <div>특이사항
            <input type="radio" name="chk" value="no" checked>없음
            <input type="radio" name="chk" value="yes">있음
         </div>
         <div>
            <textarea rows="5" cols="100" name="special" readonly="readonly" >특이사항 없음</textarea>
         </div>
         <div>
            <input type="submit" value="등록">
         </div>
      </div>
   </div>
</form>
</body>
</html>