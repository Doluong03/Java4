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
<div class="col-8 offset-3">
    <c:if test="${not empty errorMessage}">
        <div class="alert text-danger">${errorMessage}</div>
    </c:if>
    <form method="POST"
          action="/BaiTap_war/chuc-vu/update?ma=${sp.ma}">
        <h1 class="offset-4">Chức vụ</h1>
        <div class=" mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" disabled value="${sp.ma}"/>
            </div>
            <br>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${sp.ten}" />
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

