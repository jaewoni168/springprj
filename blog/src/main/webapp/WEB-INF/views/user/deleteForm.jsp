<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
 <form>
  <div class="form-group">
              <label> ID </label>
              <input type="text" id="id" value="${principal.user.id}" readOnly class="form-control">
         </div>

  <div class="form-group">
    <label for="username">사용자아이디</label>
    <input type="text" id="username" class="form-control" value="${principal.username}"
    placeholder="${principal.user.username}" readOnly >
  </div>

 <div class="form-group">
  <label for="password">패스워드</label>
    <input type="password" id="password" class="form-control" value="${principal.user.password}">
 </div>


 </form>

  <button id="btn-delete" class="btn btn-primary">회원탈퇴</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>