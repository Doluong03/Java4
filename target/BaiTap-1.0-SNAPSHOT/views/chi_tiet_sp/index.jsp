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
          href="/BaiTap_war/css/bootstrap.min.css" />
</head>
<body>
<div class="col-10 offset-1 mt-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5"> Chi tiết sản phẩm </h1>
    </div>
    <c:if test="${ f:length(listCt) == 0 }">
    <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listCt) != 0 }">
<table class="table">
    <thead>
    <tr>

        <th scope="col">Mã</th>
        <th scope="col">Sản phẩm </th>
        <th scope="col">NSX</th>
        <th scope="col">Dòng SP</th>
        <th scope="col">Màu Sắc</th>
        <th scope="col">Mô tả </th>
        <th scope="col">Năm BH</th>
        <th scope="col">Số lượng tồn</th>
        <th scope="col">Giá nhập</th>
        <th scope="col">Giá bán</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <tbody>
    <c:forEach items="${listCt}" var="ct">
        <tr>
            <td>${ ct.ma }</td>
            <td>${ ct.sanPham.ten }</td>
            <td>${ ct.nsx.ten }</td>
            <td>${ ct.dongSP.ten}</td>
            <td>${ ct.mauSac.ten }</td>
            <td>${ ct.moTa }</td>
            <td>${ ct.namBh }</td>
            <td>${ ct.soLuongTon }</td>
            <td>${ct.giaNhap}</td>
            <td>${ct.giaBan}</td>
            <td>
                <a href="/BaiTap_war/chi-tiet-sp/edit?ma=${ct.ma}" class="btn btn-primary">Cập nhật</a>
            </td>
            <td>
                <a href="/BaiTap_war/chi-tiet-sp/delete?ma=${ct.ma}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </tbody>
</table>
    </c:if>
    <div class="row mt-3">
        <div class="col-6">
            <a href="/BaiTap_war/chi-tiet-sp/create"> <button class="btn btn-primary">Thêm mới</button></a>
        </div>
        <div class="col-6"></div>
    </div>
</div>
<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>