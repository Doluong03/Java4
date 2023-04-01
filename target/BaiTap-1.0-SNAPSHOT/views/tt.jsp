<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 3/21/2023
  Time: 9:18 PM
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
<form method="POST"
      action="/BaiTap_war//update?ma=${hd.ma}">
    <h1 class="offset-4"> Thanh toán</h1>
    <div class="row mt-3">
        <div class="col-6">
            <label>Khách hàng </label>
            <select name="khach_hang" class="form-select">
                <option value="1" ${ hd.khach_hang == "1" ? "selected" : "" }>KH_A</option>
                <option value="2" ${ hd.khach_hang == "2" ? "selected" : "" }>KH_B</option>
            </select>
        </div>
        <div class="col-6">
            <label>Nhân viên  </label>
            <select name="nhan_vien" class="form-select">
                <option value="1" ${ hd.nhan_vien == "1" ? "selected" : "" }>NV_A</option>
                <option value="2" ${ hd.nhan_vien == "2" ? "selected" : "" }>NV_B</option>
            </select>
        </div>
    </div>
    <div class="row mt-3">

        <div class="col-6">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" value="${hd.ma}" />
        </div>
        <div class="col-6">
            <label>Ngày tạo </label>
            <input type="date" name="ngay_tao" class="form-control" value="${hd.ngay_tao}" />
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Ngày thanh toán </label>
            <input type="date" name="ngay_thanh_toan" class="form-control" value="${hd.ngay_thanh_toan}" />
        </div>
        <div class="col-6">
            <label>Ngày ship  </label>
            <input type="date" name="ngay_ship" class="form-control" value="${hd.ngay_ship}" />
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Ngày nhận  </label>
            <input type="date" name="ngay_nhan" class="form-control" value="${hd.ngay_nhan}" />
        </div>
        <div class="col-6">
            <label>Tình trạng </label>
            <select name="tinh_trang" class="form-select">
                <option value="1" ${ hd.tinh_trang == "dangGiao" ? "selected" : "" }>Đang giao </option>
                <option value="2" ${ hd.tinh_trang == "daGiao" ? "selected" : "" }>Đã giao </option>
            </select>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Tên người nhận</label>
            <input type="text" name="nguoi_nhan" class="form-control" value="${hd.nguoi_nhan}" />
        </div>
        <div class="col-6">
            <label>SDT</label>
            <input type="tel" name="sdt" class="form-control" value="${hd.sdt}"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Địa chỉ</label>
            <input type="text" name="dia_chi" class="form-control"  value="${hd.dia_chi}"/>
        </div>
        <div class="col-6">
            <label>Tổng tiền</label>
            <input type="text" name="tong_tien" class="form-control"  value="${hd.tong_tien}"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary" >Thanh toán</button>
        </div>
        <div class="col-6"></div>
    </div>
</form>
<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>



