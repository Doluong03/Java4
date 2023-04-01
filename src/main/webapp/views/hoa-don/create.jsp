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
    <form method="POST"
          action="/BaiTap_war/hoa-don/store">
        <h1 class="offset-4"> Hóa đơn</h1>
        <div class="row mt-3">

            <div class="col-6">
                <label>Khách hàng </label>
                <select name="khach_hang" class="form-select">
                    <option value="kh1">KH_A</option>
                    <option value="kh2">KH_B</option>
                </select>
            </div>
            <div class="col-6">
                <label>Nhân viên  </label>
                <select name="nhan_vien" class="form-select">
                    <option value="nv1">NV_A</option>
                    <option value="nv2">NV_B</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">

            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Ngày tạo </label>
                <input type="date" name="ngay_tao" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày thanh toán </label>
                <input type="date" name="ngay_thanh_toan" class="form-control" />
            </div>
            <div class="col-6">
                <label>Ngày ship  </label>
                <input type="date" name="ngay_ship" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày nhận  </label>
                <input type="date" name="ngay_nhan" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tình trạng </label>
                <select name="tinh_trang" class="form-select">
                    <option value="dangGiao">Đang giao </option>
                    <option value="">Đã giao </option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên người nhận</label>
                <input type="text" name="nguoi_nhan" class="form-control" />
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" />
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

<script src="/SP23B2_SOF3011_IT17321_war/js/bootstrap.min.js"></script>
</body>
</html>

