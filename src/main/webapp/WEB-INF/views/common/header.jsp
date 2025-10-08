<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>EZBoard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
      html, body {
          height: 100%;
      }
      body {
          display: flex;
          flex-direction: column;
      }
      main {
          flex: 1; /* 💡 본문이 남는 공간 차지 */
      }
      footer {
          background-color: #f8f9fa;
          padding: 20px 0;
          border-top: 1px solid #dee2e6;
      }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
  <div class="container">
    <a class="navbar-brand fw-bold text-primary" href="/">EZBoard</a>
    <div class="collapse navbar-collapse justify-content-end">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="/">홈</a></li>
        <li class="nav-item"><a class="nav-link" href="/board/list">게시판</a></li>
        <li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
        <li class="nav-item"><a class="nav-link" href="/join">회원가입</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- 본문 -->
<main class="container my-5">