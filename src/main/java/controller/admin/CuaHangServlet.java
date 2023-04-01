package controller.admin;

import DomainModel.CuaHang;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import viewModel.QLKhachHang;

@WebServlet({
        "/cua-hang/index",    // GET
        "/cua-hang/create",   // GET
        "/cua-hang/edit",     // GET
        "/cua-hang/delete",   // GET
        "/cua-hang/store",    // POST
        "/cua-hang/update",   // POST
})

public class CuaHangServlet extends HttpServlet {
    CuaHangRepository chr = new CuaHangRepository();


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
        request.setAttribute("view", "/views/cua-hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listCh", this.chr.findAll());
        request.setAttribute("view", "/views/cua-hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang qlch = chr.findByMa(ma);
        chr.delete(qlch);
        response.sendRedirect("/BaiTap_war/cua-hang/index");
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang qlch = chr.findByMa(ma);
        request.setAttribute("ch", qlch);
        request.setAttribute("view", "/views/cua-hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("error", "Mã không được để trống");
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("view", "/views/cua-hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (ten == null || ten.trim().isEmpty()) {
            request.setAttribute("error", "Tên không được để trống");
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("view", "/views/cua-hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        if (diaChi == null || diaChi.trim().isEmpty()) {
            request.setAttribute("error", "Địa chỉ không được để trống");
            request.setAttribute("ten", ten);
            request.setAttribute("thanhPho", thanhPho);
            request.setAttribute("ma", ma);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("quocGia", quocGia);
            request.setAttribute("view", "/views/cua-hang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        try {
            CuaHang qlch = new CuaHang();
            BeanUtils.populate(qlch, request.getParameterMap());
            chr.insert(qlch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/cua-hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            CuaHang qlch = this.chr.findByMa(ma);
            BeanUtils.populate(qlch, request.getParameterMap());
            chr.update(qlch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/BaiTap_war/cua-hang/index");
    }
}


