<%@page import="dao_p.WorkerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="text-align: center"></div>
<h3>아이디 중복 확인 결과</h3>
<%
	WorkerDAO dao = new WorkerDAO();
    //1) 사용가능한 아이디일 경우, 아이디 입력 폼에 넣기 위함
    String id=request.getParameter("id");
    int cnt=dao.duplecateID(id);
    out.println("입력 ID : <strong>" + id + "</stong>");
    if(cnt==0){
    	out.println("<p>사용 가능한 아이디입니다.</p>");
	out.println("<a href='javascript:apply(\"" + id + "\")'>[적용]</a>");
%>

	<script>
    	function apply(id){
            // 중복확인 id를 부모창에 적용시키기
            // 부모창 opener
            opener.document.parform.id.value=id;
            window.close(); //창닫기
        }//apply () end
    </script>
 <%
 	}else{
    	out.println("<p style='color: red'>해당 아이디는 사용하실 수 없습니다.</p>");
    }//if end
 %>
 <hr>
 <a href="javascript:history.back()">다시시도</a>
 &nbsp; &nbsp;
 <a href="javascript:window.close()">창닫기</a>
