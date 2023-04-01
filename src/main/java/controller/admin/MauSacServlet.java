package controller.admin;

import DomainModel.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import repositories.SanPhamRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/edit",     // GET
        "/mau-sac/delete",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/update",   // POST
})
public class MauSacServlet extends HttpServlet {
    MauSacRepository msr = new MauSacRepository();


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
        request.setAttribute("view", "/views/mau-sac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listMs", msr.findAll());
        request.setAttribute("view", "/views/mau-sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac sp = msr.findByMa(ma);
        request.setAttribute("ms", sp);
        request.setAttribute("view", "/views/mau-sac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac sp = msr.findByMa(ma);
        msr.delete(sp);
        response.sendRedirect("/BaiTap_war/mau-sac/index");

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
            MauSac qlsp = new MauSac();
            BeanUtils.populate(qlsp, request.getParameterMap());
            msr.insert(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/mau-sac/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            MauSac qlsp = msr.findByMa(ma);
            BeanUtils.populate(qlsp, request.getParameterMap());
            msr.update(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/mau-sac/index");
    }
}


