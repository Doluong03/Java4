<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 3/13/2023
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/BaiTap_war/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2 mt-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5">Khách hàng</h1>
    </div>
    <c:if test="${ f:length(danhSachKH) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachKH) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Họ</th>
                <th>Đệm</th>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>SDT</th>
                <th>Địa chỉ</th>
                <th>Thành phố</th>
                <th>Quốc gia</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSachKH }" var="kh">
                <tr>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ho }</td>
                    <td>${ kh.tenDem }</td>
                    <td>${ kh.ten }</td>
                    <td><fmt:formatDate value="${ kh.ngaySinh }" pattern="dd/MM/yyyy"/></td>
                    <td>${kh.sdt}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.thanhPho}</td>
                    <td>${kh.quocGia}</td>
                    <td>
                        <a href="/BaiTap_war/khach-hang/edit?ma=${kh.ma}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a href="/BaiTap_war/khach-hang/delete?ma=${kh.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <div class="row mt-3">
        <div class="col-6">
            <a href="/BaiTap_war/khach-hang/create">
                <button class="btn btn-primary">Thêm mới</button>
            </a>
        </div>
        <div class="col-6"></div>
    </div>
</div>

<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>