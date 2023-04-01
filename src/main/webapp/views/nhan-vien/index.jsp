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
          href="/BaiTap_war/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-11  mt-5 mx-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5">Nhân Viên</h1>
    </div>
    <c:if test="${ f:length(listNv) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listNv) != 0 }">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Họ </th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">SDT</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Chức vụ</th>
                <th scope="col">Cửa hàng</th>
                <th scope="col">Trạng thái</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listNv }" var="nv">
                <tr>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ho }</td>
                    <td>${ nv.tenDem }</td>
                    <td>${ nv.ten }</td>
                    <td><fmt:formatDate value="${ nv.ngaySinh }" pattern="dd/MM/yyyy"/></td>
                    <td>${nv.sdt}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.chucVu.ten}</td>
                    <td>${nv.cuaHang.ten}</td>
                    <td>${nv.trangThai}</td>
                    <td>
                        <a href="/BaiTap_war/nhan-vien/edit?ma=${nv.ma}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a href="/BaiTap_war/nhan-vien/delete?ma=${nv.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <div class="row mt-3">
        <div class="col-6">
            <a href="/BaiTap_war/nhan-vien/create"> <button class="btn btn-primary">Thêm mới</button></a>
        </div>
        <div class="col-6"></div>
    </div>
</div>
<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>