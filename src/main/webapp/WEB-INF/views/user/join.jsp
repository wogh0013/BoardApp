<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty existMsg}">
  <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
    ${existMsg}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>

<c:if test="${not empty errorMessages}">
    <c:forEach var="msg" items="${errorMessages}">
      <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
        ${msg} <br/>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
    </c:forEach>
</c:if>

<div class="d-flex justify-content-center align-items-center" style="min-height:80vh;">
  <div class="card p-4 shadow-sm" style="width: 400px;">
    <h4 class="text-center mb-3">회원가입</h4>

    <form method="post" action="/join">
      <div class="mb-3">
        <label class="form-label">* 아이디</label>
        <input type="text" name="userId" class="form-control" value="${userDto.userId}" required>
      </div>
      <div class="mb-3">
        <label class="form-label">* 비밀번호</label>
        <input type="password" name="userPw" class="form-control" value="${userDto.userPw}" required>
      </div>
      <div class="mb-3">
        <label class="form-label">* 이름</label>
        <input type="text" name="userNm" class="form-control" value="${userDto.userNm}" required>
      </div>
      <div class="mb-3">
        <label class="form-label">* 이메일</label>
        <input type="email" name="userEmail" class="form-control" value="${userDto.userEmail}">
      </div>
      <button type="submit" class="btn btn-success w-100">회원가입</button>
    </form>

  </div>
</div>