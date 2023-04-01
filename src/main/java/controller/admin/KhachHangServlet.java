package controller.admin;

import DomainModel.KhachHang;
//import jdk.internal.joptsimple.util.DateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import repositories.KhachHangRepository;
import viewModel.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet({
        "/khach-hang/index",    // GET
        "/khach-hang/create",   // GET
        "/khach-hang/edit",     // GET
        "/khach-hang/delete",   // GET
        "/khach-hang/store",    // POST
        "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khr = new KhachHangRepository();

    public KhachHangServlet() {
//        khr.getList().add(new QLKhachHang("KH1", "Nguyen", "Van", "A", "2003-12-03", "0985021722", "Phu do", "ha_noi", "1", "vi"));
    }

    @Override
    protected void doGet(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void create(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        request.setAttribute("danhSachKH", khr.findAll());
        request.setAttribute("view", "/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang qlkh = this.khr.findByMa(ma);
        this.khr.delete(qlkh);
        response.sendRedirect("/BaiTap_war/khach-hang/index");
    }

    protected void index(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        request.setAttribute("danhSachKH", khr.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang qlkh = this.khr.findByMa(ma);
        request.setAttribute("kh", qlkh);
        request.setAttribute("view", "/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("error", "Mã không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (ho == null || ho.trim().isEmpty()) {
            request.setAttribute("error", "Họ không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (tenDem == null || tenDem.trim().isEmpty()) {
            request.setAttribute("error", "Tên đệm không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (ten == null || ten.trim().isEmpty()) {
            request.setAttribute("error", "Tên không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (ngaySinh == null || ngaySinh.trim().isEmpty()) {
            request.setAttribute("error", "Ngày sinh không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường SĐT
        if (sdt == null || sdt.trim().isEmpty()) {
            request.setAttribute("error", "SĐT không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (sdt.length() !=10 ) {
            request.setAttribute("error", "SĐT không đúng định dạng");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường địa chỉ
        if (diaChi == null || diaChi.trim().isEmpty()) {
            request.setAttribute("error", "Địa chỉ không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường mật khẩu
        if (matKhau == null || matKhau.trim().isEmpty()) {
            request.setAttribute("error", "Mật khẩu không được để trống");
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("view", "/views/khach_hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }


        try {
            KhachHang qlkh = new KhachHang();
            ConvertUtils.register( new DateConverter(null), Date.class);
            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaySinh"));
            BeanUtils.populate(qlkh, request.getParameterMap());
            qlkh.setNgaySinh(newDate);
            khr.insert(qlkh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Tạo ArrayList & thêm vào
        response.sendRedirect("/BaiTap_war/khach-hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
           String ma = request.getParameter("ma");
            KhachHang qlkh = this.khr.findByMa(ma);
            ConvertUtils.register( new DateConverter(null), Date.class);
            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaySinh"));
            BeanUtils.populate(qlkh, request.getParameterMap());
            qlkh.setNgaySinh(newDate);
            khr.update(qlkh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Tạo ArrayList & thêm vào
        response.sendRedirect("/BaiTap_war/khach-hang/index");
    }
}


