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
          action="/BaiTap_war/nhan-vien/update?ma=${nv.ma}">
        <h1 class="offset-4"> Nhân Viên</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${nv.ma}"/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${nv.ho}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" value="${nv.tenDem}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${nv.ten}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${nv.ngaySinh}"/>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" value="${nv.sdt}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${nv.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" value="${nv.matKhau}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6 ">
                <label>Giới tính  </label>
                <br>
                <div class="form-check-inline mt-3">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1"  value="Nam" ${nv.gioiTinh == "Nam" ? "checked" : ""} >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nam
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" value="Nữ" ${nv.gioiTinh == "Nữ" ? "checked" : ""} >
                    <label class="form-check-label" for="flexRadioDefault2">
                       Nữ
                    </label>
                </div>
            </div>
            <div class="col-6">
                <label>Trạng thái </label>
                <select name="trangThai" class="form-select">
                    <option value="1" ${nv.trangThai == "1" ? "selected" : "" } >Hoạt động </option>
                    <option value="0" ${ nv.trangThai == "0" ? "selected" : "" } >Không hoạt động </option>
                </select>

            </div>
        </div>
        <div class="row mt-3">

            <div class="col-6">
                <label>Cửa hàng </label>
                <select name="cuaHang" class="form-select">
                    <option value="CH1" ${nv.cuaHang.ma == "CH1" ? "selected" : "" } >CH_A</option>
                    <option value="CH2" ${nv.cuaHang.ma == "CH2" ? "selected" : "" }>CH_B</option>
                </select>
            </div>
            <div class="col-6">
                <label>Chức vụ</label>
                <select name="chucVu" class="form-select">
                    <option value="CV1" ${nv.chucVu.ma == "CV1" ? "selected" : "" }>CV_A</option>
                    <option value="CV2" ${nv.chucVu.ma == "CV2" ? "selected" : "" }>CV_B</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Cập Nhật</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

<script src="/SP23B2_SOF3011_IT17321_war/js/bootstrap.min.js"></script>
</body>
</html>

