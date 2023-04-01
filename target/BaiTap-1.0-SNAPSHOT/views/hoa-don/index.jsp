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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/BaiTap_war/css/bootstrap.min.css" />
</head>
<body>
<div class="col-10 offset-1 mt-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5">Hóa đơn </h1>
    </div>
    <c:if test="${ f:length(listHd) == 0 }">
    <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listHd) != 0 }">
<table class="table">
    <thead>
    <tr>

        <th scope="col">Mã</th>
        <th scope="col">Khách hàng</th>
        <th scope="col">Nhân viên</th>
        <th scope="col">Ngày tạo  </th>
        <th scope="col">Ngày thanh toán </th>
        <th scope="col">Ngày Ship </th>
        <th scope="col">Ngày nhận </th>
        <th scope="col">Người nhận  </th>
        <th scope="col">SDT </th>
        <th scope="col">Địa chỉ  </th>
        <th scope="col">Tình trạng</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <tbody>
    <c:forEach items="${listHd}" var="hd">
        <tr>
            <td>${ hd.ma }</td>
            <td>${ hd.khachHang }</td>
            <td>${ hd.nhanVien }</td>
            <td><fmt:formatDate value="${ hd.ngayTao }" pattern="dd/MM/yyyy"/></td>
            <td><fmt:formatDate value="${ hd.ngayThanhToan }" pattern="dd/MM/yyyy"/></td>
            <td><fmt:formatDate value="${ hd.ngayShip }" pattern="dd/MM/yyyy"/></td>
            <td><fmt:formatDate value="${ hd.ngayNhan }" pattern="dd/MM/yyyy"/></td>
            <td>${ hd.tenNguoiNhan }</td>
            <td>${hd.sdt}</td>
            <td>${hd.diaChi}</td>
            <td>${hd.tinhTrang}</td>
            <td>
                <a href="/BaiTap_war/hoa-don/edit?ma=${hd.ma}" class="btn btn-primary">Cập nhật</a>
            </td>
            <td>
                <a href="/BaiTap_war/hoa-don/delete?ma=${hd.ma}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </tbody>
</table>
    </c:if>
    <div class="row mt-3">
        <div class="col-6">
            <a href="/BaiTap_war/hoa-don/create"> <button class="btn btn-primary">Thêm mới</button></a>
        </div>
        <div class="col-6"></div>
    </div>
</div>
<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>