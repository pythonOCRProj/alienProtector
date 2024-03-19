<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function blankCheck(f){
    	var id=f.id.value;
        id=id.trim();
        if(id.length<2){
        	alert("아이디는 2자 이상 입력해주십시오.");
            return false;
        }//if end
        return true;
    }//blankCheck() end
    </script>
<div style="text-align: center">
<h3>아이디 중복확인</h3>
   <form method="post" action="IdCheckPro" onsubmit="return blankCheck(this)">
   		아이디 : <input type="text" name="id" maxlength="20" autofocus>
   		<input type="submit" value="중복확인" >
   		<!-- onclick="sendCheckValue()" -->
   </form>
</div>