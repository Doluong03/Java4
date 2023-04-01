package controller.admin;

import DomainModel.SanPham;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import viewModel.QLCuaHang;
import viewModel.QLNhanVien;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({
        "/san-pham/index",    // GET
        "/san-pham/create",   // GET
        "/san-pham/edit",     // GET
        "/san-pham/delete",   // GET
        "/san-pham/store",    // POST
        "/san-pham/update",   // POST
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository spr = new SanPhamRepository();

    public SanPhamServlet() {
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
        request.setAttribute("view", "/views/san-pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listSp", spr.findAll());
        request.setAttribute("view", "/views/san-pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = spr.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/san-pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = spr.findByMa(ma);
        spr.delete(sp);
        response.sendRedirect("/BaiTap_war/san-pham/index");

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        if (ma == null || ma.trim().isEmpty()) {
            // Nếu mã sản phẩm không được nhập, hiển thị thông báo lỗi và ngăn chặn việc lưu trữ thông tin vào database
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin sản phẩm.");
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            request.setAttribute("view", "/views/san-pham/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        if (ten == null || ten.trim().isEmpty()) {
            // Nếu tên sản phẩm không được nhập, hiển thị thông báo lỗi và ngăn chặn việc lưu trữ thông tin vào database
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin sản phẩm.");
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            request.setAttribute("view", "/views/san-pham/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        try {
            SanPham qlsp = new SanPham();
            BeanUtils.populate(qlsp, request.getParameterMap());
            spr.insert(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/san-pham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            SanPham qlsp = this.spr.findByMa(ma);
            BeanUtils.populate(qlsp, request.getParameterMap());
            spr.update(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/san-pham/index");
    }
}


