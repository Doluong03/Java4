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
          action="/BaiTap_war/chi-tiet-sp/update?ma=${ct.ma}">
        <h1 class="offset-4"> Chi tiết sản phẩm </h1>
        <div class="row mt-3">

            <div class="col-6">
                <label>Sản phẩm</label>
                <select name="sanPham" class="form-select">
                    <option value="SP1" ${ ct.sanPham.ma == "SP1" ? "selected" : "" }>SP_A</option>
                    <option value="SP2" ${ ct.sanPham.ma == "SP2" ? "selected" : "" }>SP_B</option>
                </select>
            </div>
            <div class="col-6">
                <label>NSX</label>
                <select name="nsx" class="form-select">
                    <option value="NSX1" ${ ct.nsx.ma == "NSX1" ? "selected" : "" }>NSX_A</option>
                    <option value="NSX2" ${ ct.nsx.ma == "NSX2" ? "selected" : "" }>NSX_B</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">

            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select name="dongSP" class="form-select">
                    <option value="DSP1" ${ ct.dongSP.ma == "DSP1" ? "selected" : "" }>DSP_A</option>
                    <option value="DSP2" ${ ct.dongSP.ma == "DSP2" ? "selected" : "" }>DSP_B</option>
                </select>
            </div>
            <div class="col-6">
                <label>Màu sắc </label>
                <select name="mauSac" class="form-select">
                    <option value="MS1" ${ ct.mauSac.ma == "MS1" ? "selected" : "" }>MS_A</option>
                    <option value="MS2" ${ ct.mauSac.ma == "MS2" ? "selected" : "" }>MS_B</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ct.ma}" />
            </div>
            <div class="col-6">
                <label>Năm bảo hành </label>
                <input type="number" name="namBh" class="form-control" value="${ct.namBh}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="moTa" class="form-control" value="${ct.moTa}" />
            </div>
            <div class="col-6">
                <label> Số lượng tồn</label>
                <input type="number" name="soLuongTon" class="form-control" value="${ct.soLuongTon}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá nhập   </label>
                <input type="number" name="giaNhap" class="form-control" value="${ct.giaNhap}"/>
            </div>
            <div class="col-6">
                <label>Giá bán </label>
                <input type="number" name="giaBan" class="form-control" value="${ct.giaBan}"/>
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

