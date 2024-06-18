<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form class="container" method="post">
       <div class="mb-3">
          <label class="form-label">건의사항</label>
             <input type="text" class="form-control" name="title" id="title">


        </div>
       <div class="mb-3">
            <label class="form-label">건의내용</label>
            <textarea class="form-control summernote" rows="3" name="content" id="content"></textarea>
       </div>
       </form>
      <button type="button" class="btn btn-danger" onclick="location.href='http://localhost:8087'">취소</button>
      <button type="submit" class="btn btn-primary" id="btn-write" onclick="location.href='http://localhost:8087'">
      작성완료</button>
</div>
<script>
$('.summernote').summernote({
      placeholder: '',
       tabsize: 2,
       height: 300
});
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>