<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 3/21/2023
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">IT17321</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/BaiTap_war//">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BaiTap_war/khach-hang/index">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BaiTap_war/san-pham/index">Sản phẩm</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="carouselExampleIndicators" class="carousel slide">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/BaiTap_war/Anh/524_attimg1_origin.jpg" class="d-block w-100 h-50" alt="">
        </div>
        <div class="carousel-item">
            <img src="/BaiTap_war/Anh/523_attimg1_origin.jpg" class="d-block w-100 h-50" alt="">
        </div>
        <div class="carousel-item">
            <img src="/BaiTap_war/Anh/522_attimg1_origin.jpg" class="d-block w-100 h-50" alt="">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<div class="row" style="min-height: 500px;">
    <div class="col-3 ">
        <div class="offcanvas-header " style="background-color: #4c57be;">
            <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel" style="color: #61170E;">MENU</h5>
        </div>
        <div class="offcanvas-body" style="background-color:#94a7f5;">
            <nav id="sidebar">
                <ul class="list-unstyled components mt-3">

                    <div class="dropdown">
                        <a class="btn  dropdown-toggle" href="" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <li class="active  mt-5 mx-4 fw-bold fs-4  "  style="color: #963E2C;">Sản phẩm</li>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/BaiTap_war/san-pham/index">Sản phẩm</a></li>
                            <li><a class="dropdown-item" href="/BaiTap_war/chi-tiet-sp/index">Chi tiết sản phẩm</a></li>
                            <li><a class="dropdown-item" href="/BaiTap_war/dong-sp/index">Dòng sản phẩm</a></li>
                            <li><a class="dropdown-item" href="/BaiTap_war/nsx/index">Nhà sản xuất</a></li>
                            <li><a class="dropdown-item" href="/BaiTap_war/mau-sac/index">Màu sắc</a></li>
                        </ul>
                    </div>

                    <li class="mb-2 mt-5 mx-5 fw-bold fs-3 "><a href="#" class="text-decoration-none "
                                                                style="color: #963E2C;"></a></li>
                    <hr>
                    <li class="mb-2 mt-5 mx-5 fw-bold fs-3 "><!-- Link with dropdown items -->
                        <a href="/BaiTap_war/khach-hang/index" data-toggle="collapse" aria-expanded="false"
                           class="text-decoration-none " style="color: #963E2C;">Khách hàng</a></li>
                    <hr>
                    <li class="mb-2 mt-5 mx-5 fw-bold fs-3 "><a class="text-decoration-none " style="color: #963E2C;"
                                                                href="/BaiTap_war/cua-hang/index">Cửa hàng</a></li>
                    <hr>
                    <div class="dropdown">
                        <a class="btn  dropdown-toggle" href="" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <li class="active  mt-5 mx-4 fw-bold fs-4  "  style="color: #963E2C;">Nhân viên</li>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/BaiTap_war/nhan-vien/index">Nhân viên</a></li>
                            <li><a class="dropdown-item" href="/BaiTap_war/chuc-vu/index">Chức vụ</a></li>
                        </ul>
                    </div>
                </ul>
            </nav>
        </div>
    </div>
    <div class="col-9">
        <jsp:include page="${ view }"/>
    </div>
</div>

<footer class="text-center text-lg-start text-white " style="background-color: #024137">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-between pt-4 px-4 mx-4 fst-italic fs-1 "
             style="background-color: #024137">
        <!-- Left -->

        <!-- Left -->
    </section>
    <!-- Right -->
    <div class="row  mt-0">
        <div class="col-1 text-end offset-9" style="height: 50px;">
        </div>
        <div class=" text-start   col-2">
            © 2020 innisfree Inc. <br>
            All rights reserved.
        </div>
    </div>
    <div class="mx-5 ">
        <a href="" class="text-white fs-2 mx-5 me-4 text-decoration-none">
            <i class="fa-brands fa-facebook"></i>
        </a>
        <a href="" class="text-white me-4 fs-2 text-decoration-none">
            <i class="fa-brands fa-instagram"></i>
        </a>
        <a href="" class="text-white me-4 fs-2 text-decoration-none">
            <i class="fab fa-youtube"></i>
        </a>
        <a href="" class="text-white me-4 fs-2">
            <i class="fa-brands fa-github"></i> </a>

    </div>


    <!-- Right -->

    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="mx-5 text-center text-md-start mt-5 ">
            <!-- Grid row -->
            <div class="row mt-3 mx-2">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold"><a href="#" class="text-decoration-none text-light">Chính
                        sách giao hàng và thanh toán </a></h6>
                    <hr class="mb-4 mt-0 d-inline-block mx-auto"
                        style="width: 60px; background-color: #7c4dff; height: 2px"/>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-3 col-xl-3 mx-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold"><a href="#" class="text-decoration-none text-light">Chính
                        sách bảo mật thông tin khách hàng</a></h6>
                    <hr class="mb-4 mt-0 d-inline-block mx-auto"
                        style="width: 60px; background-color: #7c4dff; height: 2px"/>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold "><a href="#" class="text-decoration-none text-light">Chính
                        sách mua hàng</a></h6>
                    <hr class="mb-4 mt-0 d-inline-block mx-auto"
                        style="width: 60px; background-color: #7c4dff; height: 2px"/>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold"><a href="#" class="text-decoration-none text-light">Chính
                        sách trả hàng</a></h6>
                    <hr class="mb-4 mt-0 d-inline-block mx-auto"
                        style="width: 60px; background-color: #7c4dff; height: 2px"/>

                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
            <div class="mx-5">
                <div>
                    Thời gian làm việc Thứ 2 ~ Thứ 6 09:00 ~ 17:00 (trừ Thứ 7, Chủ Nhật và ngày lễ)
                </div>
                <div>Tư vấn và chăm sóc khách hàng 028 3827 9777 (Ext: 125)</div>
                <div>Email cs_vn@innisfree.com</div>
                <br>
                <div>CÔNG TY TNHH AMOREPACIFIC VIỆT NAM</div>
                <div>GIẤY CNĐKDN: 0309984165 - Ngày cấp: 05/05/2010, được sửa đổi lần thứ 21, ngày 04/04/2022</div>
                <div>Cơ quan cấp: Phòng Đăng kí kinh doanh - Sở Kế hoạch và Đầu tư TP.HCM</div>
                <div>Địa chỉ đăng ký kinh doanh: Lầu 4A, Toà nhà Vincom, 72 Lê Thánh Tôn, Phường Bến Nghé, Quận 1,
                    Tp. Hồ Chí Minh, Việt Nam.
                </div>
            </div>
        </div>
        <br>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <!-- Copyright -->
</footer>
<!-- Footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
