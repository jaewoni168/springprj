<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<div class="container">
     <form>

      <div class="form-group">
           <label for="username">사용자아이디</label>
          <input type="text" id="username"
            value="${principal.user.username}" class="form-control" readOnly>
      </div>
      <div class="form-group">
          <label for="password">패스워드</label>
        <input type="password" id="password" class="form-control" readOnly
         value="${principal.user.password}">
       </div>
     <div class="form-group">
        <label for="email">이메일</label>
         <input type="email" id="email" class="form-control"
         value="${principal.user.email}">
     </div>
    </form>
   <button id="btn-update" class="btn btn-primary">회원수정완료</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>