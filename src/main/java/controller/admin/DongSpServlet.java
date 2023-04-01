package controller.admin;

import DomainModel.DongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSpRepository;
import repositories.SanPhamRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/dong-sp/index",    // GET
        "/dong-sp/create",   // GET
        "/dong-sp/edit",     // GET
        "/dong-sp/delete",   // GET
        "/dong-sp/store",    // POST
        "/dong-sp/update",   // POST
})
public class DongSpServlet extends HttpServlet {
    DongSpRepository dspr = new DongSpRepository();


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
        request.setAttribute("view", "/views/dong-sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listDsp", dspr.findAll());
        request.setAttribute("view", "/views/dong-sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP sp = dspr.findByMa(ma);
        request.setAttribute("dsp", sp);
        request.setAttribute("view", "/views/dong-sp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP sp = dspr.findByMa(ma);
        dspr.delete(sp);
        response.sendRedirect("/BaiTap_war/dong-sp/index");

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
            DongSP qlsp = new DongSP();
            BeanUtils.populate(qlsp, request.getParameterMap());
            dspr.insert(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/dong-sp/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            DongSP qlsp = this.dspr.findByMa(ma);
            BeanUtils.populate(qlsp, request.getParameterMap());
            dspr.update(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/dong-sp/index");
    }
}


