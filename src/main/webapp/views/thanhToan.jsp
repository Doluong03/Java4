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
<div class="col-10 offset-1 mt-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5">Giỏ hàng</h1>
    </div>
    <c:if test="${ f:length(listCt2) == 0 }">
        <h3>Không có dữ liệu</h3>
        <a class="btn btn-primary btn-sm" href="/BaiTap_war//">Add more</a>
    </c:if>
    <c:if test="${ f:length(listCt2) != 0 }" var ="ma">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Hóa đơn  </th>
                <th scope="col">Sản phẩm </th>
                <th scope="col">NSX</th>
                <th scope="col">Dòng SP</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Giá bán</th>
                <th scope="col">Tổng tiền</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <tbody>
        <c:set var="ma_hd" value="" />
        <c:set var="total" value="0" />
        <c:forEach items="${listCt2}" var="ct" >
                <tr>
                    <td>${ ct.ma_hd }</td>
                    <td>${ ct.ma_ct }</td>
                    <td>${ ct.ma_sp }</td>
                    <td>${ ct.ten_sp }</td>
                    <td>${ ct.so_luong }</td>
                    <td>${ ct.don_gia }</td>
                    <td>${ ct.tong_tien }</td>
                    <td>
                        <a href="/BaiTap_war//delete?ma=${ct.ma_ct}" class="btn btn-primary">remove</a>
                    </td>
                </tr>
                <c:set var="ma_hd" value="${ct.ma_hd}" />
                <c:set var="total" value="${total + ct.tong_tien}" />
            </c:forEach>
            </tbody>
            </tbody>
        </table>
        <div class="row">
            <a class="btn btn-primary btn-sm col-1 offset-2" href="/BaiTap_war//">Add more</a>
            <a class="btn btn-primary btn-sm col-1 offset-2"  href="/BaiTap_war//thanhToan?ma=${ma_hd}&total=${total}">Thanh toan</a>
        </div>

    </c:if>
</div>
<script src="/BaiTap_war/js/bootstrap.min.js"></script>
</body>
</html>



