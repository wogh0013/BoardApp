<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- header.jsp -->

<style>
  .navbar-nav {display: flex;align-items: center;}
  .navbar-nav .nav-item {display: inline-flex;align-items: center;}
  .navbar-nav .nav-item:not(:last-child)::after {content: "|";color: #6c757d;margin: 0 10px;vertical-align: middle;}
  .navbar-nav .btn-link {display: inline-flex;align-items: center;}
</style>

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
  <div class="container">
    <%-- 로고 --%>
    <a class="navbar-brand fw-bold text-primary" href="/">Seoul-Eats</a>

    <div class="collapse navbar-collapse justify-content-end">
      <ul class="navbar-nav align-items-center">

        <c:choose>
          <%-- 로그인 상태 --%>
          <c:when test="${not empty sessionScope.loginUser}">
            <li class="nav-item">
              <span class="nav-link text-success" style="cursor:default;">
                ${sessionScope.loginUser.userNm}님 환영합니다!
              </span>
            </li>

            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/">홈</a></li>
            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/board/list">Seoul-Eats</a></li>
            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/user/mypage">마이페이지</a></li>
            <li class="nav-item">
              <form action="/logout" method="post" class="m-0 p-0" onsubmit="return confirm('정말 로그아웃하시겠습니까?');">
                <button type="submit" class="nav-link btn btn-link p-0 text-secondary px-2" style="text-decoration:none;">
                  로그아웃
                </button>
              </form>
            </li>
          </c:when>

          <%-- 로그아웃 상태 --%>
          <c:otherwise>
            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/">홈</a></li>
            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/board/list">Seoul-Eats</a></li>
            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/login">로그인</a></li>
            <li class="nav-item"><a class="nav-link text-secondary px-2" href="/join">회원가입</a></li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>

<main class="container my-5">
