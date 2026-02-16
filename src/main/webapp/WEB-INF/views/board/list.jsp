<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="d-flex justify-content-between align-items-center mb-4">
  <div>
    <h2 class="fw-bold mb-1">서울 맛집 리스트 게시판</h2>
    <p class="text-muted mb-0">좋아하는 맛집을 공유해보세요.</p>
  </div>
</div>

<c:if test="${not empty msgCode}">
  <div class="alert alert-info alert-dismissible fade show" role="alert">
    <spring:message code="${msgCode}" />
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>

<div class="card shadow-sm mb-4">
  <div class="card-header bg-white">
    <strong>맛집 등록</strong>
  </div>
  <div class="card-body">
    <form method="post" action="/board/add" class="row g-3">
      <div class="col-md-4">
        <label class="form-label">가게 이름 *</label>
        <input type="text" name="name" class="form-control" value="${restaurantForm.name}">
      </div>
      <div class="col-md-3">
        <label class="form-label">지역 *</label>
        <input type="text" name="area" class="form-control" value="${restaurantForm.area}" placeholder="예: 마포구">
      </div>
      <div class="col-md-3">
        <label class="form-label">대표 메뉴 *</label>
        <input type="text" name="menu" class="form-control" value="${restaurantForm.menu}" placeholder="예: 라멘">
      </div>
      <div class="col-md-12">
        <label class="form-label">메모</label>
        <input type="text" name="memo" class="form-control" value="${restaurantForm.memo}" placeholder="추천 이유/웨이팅 정보 등">
      </div>
      <div class="col-12 text-end">
        <button type="submit" class="btn btn-primary">등록하기</button>
      </div>
    </form>
  </div>
</div>

<div class="card shadow-sm">
  <div class="card-header bg-white">
    <strong>맛집 목록</strong>
  </div>
  <div class="table-responsive">
    <table class="table table-hover align-middle mb-0">
      <thead class="table-light">
      <tr>
        <th style="width: 8%">번호</th>
        <th style="width: 25%">가게 이름</th>
        <th style="width: 18%">지역</th>
        <th style="width: 20%">대표 메뉴</th>
        <th>메모</th>
      </tr>
      </thead>
      <tbody>
      <c:choose>
        <c:when test="${empty restaurantList}">
          <tr>
            <td colspan="5" class="text-center text-muted py-4">등록된 맛집이 없습니다. 첫 맛집을 등록해보세요!</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="item" items="${restaurantList}">
            <tr>
              <td>${item.id}</td>
              <td class="fw-semibold">${item.name}</td>
              <td>${item.area}</td>
              <td>${item.menu}</td>
              <td>${item.memo}</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
      </tbody>
    </table>
  </div>
</div>