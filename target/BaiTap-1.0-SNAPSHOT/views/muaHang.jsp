<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 3/21/2023
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-10 offset-1 mt-5 table-responsive">
    <div>
        <h1 class="offset-4 mb-5">Sản phẩm</h1>
    </div>
    <c:if test="${ f:length(listCt) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listCt) != 0 }">
        <c:forEach var="sp" items="${listCt}">
            <div class="col-sm-4">
                <div class="card mb-3">
                    <img src="/BaiTap_war/Anh/501_ID0101_1.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${sp.sanPham.ten}</h5>
                        <p class="card-text">${sp.moTa}</p>
                        <p class="card-text">Price: ${sp.giaBan}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>


