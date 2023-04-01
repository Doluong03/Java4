<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 3/13/2023
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/BaiTap_war/css/bootstrap.min.css" />
</head>
<body>
<div class="col-8 offset-2">
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <form method="POST"
          action="/BaiTap_war/khach-hang/store">
        <h1 class="offset-4">Khách hàng</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${not empty ma ? ma : ''}"/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value=" ${not empty ho ? ho : ''}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" value="${not empty tenDem ? tenDem : ''}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${not empty ten ? ten : ''}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control"  value="${not empty ngaySinh ? ngaySinh : ''}"/>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" value="${not empty sdt ? sdt : ''}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${not empty diaChi ? diaChi : ''}" />
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" value="${not empty matKhau ? matKhau : ''}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vi">Việt Nam</option>
                    <option value="us">Mỹ</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="ha_noi">Hà Nội</option>
                    <option value="new_york">New York</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>

