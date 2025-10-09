<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty msg}">
  <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
    ${msg}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>

<c:if test="${not empty loginError}">
  <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
    ${loginError}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>

<div class="d-flex justify-content-center align-items-center" style="min-height:70vh;">
  <div class="card p-4 shadow-sm" style="width: 360px;">
    <h4 class="text-center mb-3">로그인</h4>

    <form method="post" action="/login">
      <div class="mb-3">
        <label class="form-label">아이디</label>
        <input type="text" name="userId" class="form-control" value="${userId}" required>
      </div>
      <div class="mb-3">
        <label class="form-label">비밀번호</label>
        <input type="password" name="userPw" class="form-control" value="${userPw}" required>
      </div>
      <button type="submit" class="btn btn-primary w-100">로그인</button>

      <a href="/join" class="btn btn-link w-100 mt-2">회원가입</a>
      <p class="text-danger text-center mt-2">${error}</p>
    </form>

  </div>
</div>