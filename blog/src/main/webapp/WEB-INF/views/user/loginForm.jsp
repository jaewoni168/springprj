<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form action="/auth/loginProc" method="post">

         <div class="form-group">
             <label for="username">Username</label>
              <input type="text" name="username" class="form-control"
              id="username">
          </div>

         <div class="form-group">
           <label for="password">Password</label>
            <input type="password" name="password" id="password"
            class="form-control">
       </div>

       <div class="form-group form-check">
           <label class="form-check-label">
                 <input class="form-check-input" type="checkbox" id="memory" >Remember me
         </label>
       </div>
  <button id="btn-login" class="btn btn-primary">로그인</button>

  </form>
<button><a href="/auth/joinForm">회원가입</a></button>
</div>
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>