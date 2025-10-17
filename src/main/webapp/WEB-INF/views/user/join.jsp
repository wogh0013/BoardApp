<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(document).ready(function(){
    let debounceTimer;

    $("#userId").on("keyup", function(){
        clearTimeout(debounceTimer);

        const userId = $(this).val().trim();
        const idCheckMsg = $("#idCheckMsg");

        if(userId.length < 4){
            idCheckMsg.text("아이디는 4자 이상 입력해 주세요.").css("color", "gray");
            return;
        }

        debounceTimer = setTimeout(function() {
            $.ajax({
                url: "/join/checkId",
                method: "GET",
                dataType: "json",
                data: {userId: userId},
                success: function(isAvailable) {
                console.log(isAvailable);
                    if(isAvailable === true) {
                        idCheckMsg.text("사용 가능한 아이디입니다.").css("color", "green");
                    } else {
                        idCheckMsg.text("이미 존재하는 아이디입니다.").css("color", "red");
                    }
                },
                error: function() {
                    idCheckMsg.text("서버 오류가 발생했습니다.").css("color", "red");
                }
            });
        }, 250);
    });
});
</script>

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
        <input type="text" id="userId" name="userId" class="form-control" value="${userDto.userId}" required>
        <div id="idCheckMsg" class="mt-1 small"></div>
      </div>
      <div class="mb-3">
        <label class="form-label">* 비밀번호</label>
        <input type="password" name="userPw" class="form-control" required>
      </div>
      <div class="mb-3">
          <label class="form-label">* 비밀번호 확인</label>
          <input type="password" name="userPwConfirm" class="form-control" required>
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