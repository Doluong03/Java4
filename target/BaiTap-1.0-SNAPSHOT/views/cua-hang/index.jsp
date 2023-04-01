<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 3/13/2023
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/BaiTap_war/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2 mt-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5"> Cửa Hàng </h1>
    </div>
<c:if test="${ f:length(listCh) == 0 }">
    <h3>Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(listCh) != 0 }">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th colspan="2">Thao tác</th>        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCh}" var="ch">
            <tr>
                <td>${ ch.ma }</td>
                <td>${ ch.ten }</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <a href="/BaiTap_war/cua-hang/edit?ma=${ch.ma}" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/BaiTap_war/cua-hang/delete?ma=${ch.ma}"  class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
    <div class="row mt-3">
        <div class="col-6">
            <a href="/BaiTap_war/cua-hang/create"> <button class="btn btn-primary">Thêm mới</button></a>
        </div>
        <div class="col-6"></div>
    </div>
    </div>
<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>