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
          href="/BaiTap_war/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2">
    <form method="POST"
          action="/BaiTap_war/cua-hang/update?ma=${ch.ma}">
        <h1 class="offset-4"> Cửa Hàng</h1>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ch.ma}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ch.ten}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${ch.diaChi}"/>
            </div>

            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vi" ${ch.quocGia == "vi" ? "selected" : ""}>Việt Nam</option>
                    <option value="us" ${ch.quocGia == "us" ? "selected" : ""}>Mỹ</option>
                </select>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="ha_noi"${ ch.thanhPho == "ha_noi" ? "selected" : "" }>Hà Nội</option>
                        <option value="new_york" ${ ch.thanhPho == "new_york" ? "selected" : "" }>New York</option>
                    </select>
                </div>
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

