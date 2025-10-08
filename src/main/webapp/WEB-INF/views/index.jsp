<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>
    <title>EZBoard</title>
    <!-- Bootstrap CSS 추가 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="container mt-5">
    <div class="text-center">
        <h1 class="display-5 fw-bold text-primary">Welcome to EZBoard!</h1>
        <p class="lead text-muted mt-3">간단하고 깔끔한 게시판 프로젝트</p>

        <a href="/board/list" class="btn btn-primary btn-lg mt-4">
            게시판 바로가기
        </a>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<!-- Bootstrap JS 추가 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>