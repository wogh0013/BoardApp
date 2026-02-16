<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-flex justify-content-center align-items-center" style="min-height:80vh;">
    <div class="card p-4 shadow-sm" style="width: 450px;">
        <h4 class="text-center mb-4">마이페이지</h4>

        <table class="table table-bordered">
            <tbody>
                <tr>
                    <th style="width: 30%;">아이디</th>
                    <td>${loginUser.userId}</td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td>${loginUser.userNm}</td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>${loginUser.userEmail}</td>
                </tr>
                <tr>
                    <th>가입일</th>
                    <td>${loginUser.regDt}</td>
                </tr>
            </tbody>
        </table>

        <form method="post" action="/user/delete" onsubmit="return confirm('정말 탈퇴하시겠습니까?');">
            <button type="submit" class="btn btn-danger w-100 mt-3">회원 탈퇴</button>
        </form>
    </div>
</div>