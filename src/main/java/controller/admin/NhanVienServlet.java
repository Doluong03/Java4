package controller.admin;

import DomainModel.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;
import viewModel.QLHoaDon;
import viewModel.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})
public class NhanVienServlet extends HttpServlet {
    ArrayList<NhanVien> ListNv = new ArrayList<>();
    NhanVienRepository nvr = new NhanVienRepository();
    ChucVuRepository cvr = new ChucVuRepository();
    CuaHangRepository chr = new CuaHangRepository();

    public NhanVienServlet() {

    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
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
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
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
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhan-vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listNv", this.nvr.findAll());
        request.setAttribute("view", "/views/nhan-vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response
    ) throws jakarta.servlet.ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien qlkh = this.nvr.findByMa(ma);
        request.setAttribute("nv", qlkh);
        request.setAttribute("view", "/views/nhan-vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nvr.findByMa(ma);
        nvr.delete(nv);
        response.sendRedirect("/BaiTap_war/nhan-vien/index");
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
        String matKhau = request.getParameter("matKhau");
        String gioiTinh = request.getParameter("gioiTinh");
        String trangThai = request.getParameter("trangThai");

        // Kiểm tra trường mã
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("error", "Mã không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường họ
        if (ho == null || ho.trim().isEmpty()) {
            request.setAttribute("error", "Họ không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường tên đệm
        if (tenDem == null || tenDem.trim().isEmpty()) {
            request.setAttribute("error", "Tên đệm không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường tên
        if (ten == null || ten.trim().isEmpty()) {
            request.setAttribute("error", "Tên không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường ngày sinh
        if (ngaySinh == null || ngaySinh.trim().isEmpty()) {
            request.setAttribute("error", "Ngày sinh không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường SĐT
        if (sdt == null || sdt.trim().isEmpty()) {
            request.setAttribute("error", "SĐT không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (sdt.length() < 10 || sdt.length() > 10) {
            request.setAttribute("error", "SĐT phải đúng định dạng");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường địa chỉ
        if (diaChi == null || diaChi.trim().isEmpty()) {
            request.setAttribute("error", "Địa chỉ không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        // Kiểm tra trường mật khẩu
        if (matKhau == null || matKhau.trim().isEmpty()) {
            request.setAttribute("error", "Mật khẩu không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("ho", ho);
            request.setAttribute("tenDem", tenDem);
            request.setAttribute("ten", ten);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("sdt", sdt);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("matKhau", matKhau);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("view", "/views/nhan-vien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        NhanVien qlnv = new NhanVien();
        String maCH = request.getParameter("cuaHang");
        String maCV = request.getParameter("chucVu");

        CuaHang cuaHang = chr.findByMa(maCH);
        if (cuaHang != null) {
            qlnv.setCuaHang(cuaHang);
        }

        ChucVu chucVu = cvr.findByMa(maCV);
        if (chucVu != null) {
            qlnv.setChucVu(chucVu);
        }
        Map<String, String[]> paramMap = new HashMap<>(request.getParameterMap());
        paramMap.remove("cuaHang");
        paramMap.remove("chucVu");
        ConvertUtils.register(new DateConverter(null), Date.class);
        try {
            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaySinh"));
            BeanUtils.populate(qlnv, paramMap);
            qlnv.setNgaySinh(newDate);
            nvr.insert(qlnv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/BaiTap_war/nhan-vien/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien qlnv = this.nvr.findByMa(ma);
        String maCH = request.getParameter("cuaHang");
        String maCV = request.getParameter("chucVu");
        CuaHang cuaHang = chr.findByMa(maCH);
        if (cuaHang != null) {
            qlnv.setCuaHang(cuaHang);
        }
        ChucVu chucVu = cvr.findByMa(maCV);
        if (chucVu != null) {
            qlnv.setChucVu(chucVu);
        }
        Map<String, String[]> paramMap = new HashMap<>(request.getParameterMap());
        paramMap.remove("cuaHang");
        paramMap.remove("chucVu");
        ConvertUtils.register(new DateConverter(null), Date.class);
        try {
            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaySinh"));
            BeanUtils.populate(qlnv, paramMap);
            qlnv.setNgaySinh(newDate);
            nvr.update(qlnv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/BaiTap_war/nhan-vien/index");
    }
}




