package controller.admin;

import DomainModel.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.*;
import viewModel.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


@WebServlet({
        "/chi-tiet-sp/index",    // GET
        "/chi-tiet-sp/create",   // GET
        "/chi-tiet-sp/edit",     // GET
        "/chi-tiet-sp/delete",   // GET
        "/chi-tiet-sp/store",    // POST
        "/chi-tiet-sp/update",   // POST
})
public class ChiTietSpServlet extends HttpServlet {
    private ChiTietSpRepository ctsr = new ChiTietSpRepository();
    private SanPhamRepository spr = new SanPhamRepository();
    private NsxRepository nr = new NsxRepository();
    private DongSpRepository dspr = new DongSpRepository();
    private MauSacRepository msr = new MauSacRepository();

    public ChiTietSpServlet() {
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
        request.setAttribute("danhSachKH", ctsr.findAll());
        request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP qlct = this.ctsr.findByMa(ma);
        this.ctsr.delete(qlct);
        response.sendRedirect("/BaiTap_war/chi-tiet-sp/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listCt", ctsr.findAll());
        request.setAttribute("view", "/views/chi_tiet_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP qlct = this.ctsr.findByMa(ma);
        request.setAttribute("ct", qlct);
        request.setAttribute("view", "/views/chi_tiet_sp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String moTa = request.getParameter("moTa");
        String namBh = request.getParameter("namBh");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("error", "Mã sản phẩm không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (moTa == null || moTa.trim().isEmpty()) {
            request.setAttribute("error", "Mô tả không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (namBh == null || namBh.trim().isEmpty()) {
            request.setAttribute("error", "Năm bảo hành không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (Double.parseDouble(namBh) < 0) {
            request.setAttribute("error", "Năm bảo hành không được nhỏ hơn 0");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (soLuongTon == null || soLuongTon.trim().isEmpty()) {
            request.setAttribute("error", "Số lượng tồn không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (Double.parseDouble(soLuongTon) < 0) {
            request.setAttribute("error", "Số lượng tồn không được nhỏ hơn 0");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (giaNhap == null || giaNhap.trim().isEmpty()) {
            request.setAttribute("error", "Giá nhập không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (giaBan == null || giaBan.trim().isEmpty()) {
            request.setAttribute("error", "Giá bán không được để trống");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (Double.parseDouble(giaBan) < 0 || giaBan.trim().isEmpty()) {
            request.setAttribute("error", "Giá bán không được  nhỏ hơn 0 ");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }
        if (Double.parseDouble(giaNhap) < 0) {
            request.setAttribute("error", "Giá nhập không được nhỏ hơn 0 ");
            request.setAttribute("ma", ma);
            request.setAttribute("sanPham", request.getParameter("sanPham"));
            request.setAttribute("nsx", request.getParameter("nsx"));
            request.setAttribute("mauSac", request.getParameter("mauSac"));
            request.setAttribute("dongSp", request.getParameter("dongSp"));
            request.setAttribute("namBh", request.getParameter("namBh"));
            request.setAttribute("moTa", request.getParameter("moTa"));
            request.setAttribute("soLuongTon", request.getParameter("soLuongTon"));
            request.setAttribute("giaNhap", request.getParameter("giaNhap"));
            request.setAttribute("giaBan", request.getParameter("giaBan"));
            request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
            return;
        }


        ChiTietSP qlct = new ChiTietSP();
        String maSP= request.getParameter("sanPham");
        String maDsp= request.getParameter("dongSp");
        String maMs= request.getParameter("mauSac");
        String maNsx= request.getParameter("nsx");
        qlct.setSanPham(spr.findByMa(maSP));
        qlct.setDongSP(dspr.findByMa(maDsp));
        qlct.setMauSac(msr.findByMa(maMs));
        qlct.setNsx(nr.findByMa(maNsx));
        Map<String, String[]> paramMap = new HashMap<>(request.getParameterMap());
        paramMap.remove("sanPham");
        paramMap.remove("dongSp");
        paramMap.remove("mauSac");
        paramMap.remove("nsx");
        try {
            BeanUtils.populate(qlct, paramMap);
            ctsr.insert(qlct);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Tạo ArrayList & thêm vào
        response.sendRedirect("/BaiTap_war/chi-tiet-sp/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP qlct = ctsr.findByMa(ma);
        String maSP = request.getParameter("sanPham");
        String maDsp = request.getParameter("dongSP");
        String maMs = request.getParameter("mauSac");
        String maNsx = request.getParameter("nsx");
        SanPham sanPham = spr.findByMa(maSP);
        if (sanPham != null) {
            qlct.setSanPham(sanPham);
        }
        DongSP dongSanPham = dspr.findByMa(maDsp);
        if (dongSanPham != null) {
            qlct.setDongSP(dongSanPham);
        }
        MauSac mauSac = msr.findByMa(maMs);
        if (mauSac != null) {
            qlct.setMauSac(mauSac);
        }
        Nsx nhaSanXuat = nr.findByMa(maNsx);
        if (nhaSanXuat != null) {
            qlct.setNsx(nhaSanXuat);
        }
        Map<String, String[]> paramMap = new HashMap<>(request.getParameterMap());
        paramMap.remove("sanPham");
        paramMap.remove("dongSP");
        paramMap.remove("mauSac");
        paramMap.remove("nsx");
        try {
            BeanUtils.populate(qlct, paramMap);
            ctsr.update(qlct);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Tạo ArrayList & thêm vào
        response.sendRedirect("/BaiTap_war/chi-tiet-sp/index");
    }
}


