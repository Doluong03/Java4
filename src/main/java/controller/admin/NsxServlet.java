package controller.admin;

import DomainModel.Nsx;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NsxRepository;
import repositories.SanPhamRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nsx/index",    // GET
        "/nsx/create",   // GET
        "/nsx/edit",     // GET
        "/nsx/delete",   // GET
        "/nsx/store",    // POST
        "/nsx/update",   // POST
})
public class NsxServlet extends HttpServlet {
    NsxRepository nsxr = new NsxRepository();


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
        request.setAttribute("view", "/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listNsx", nsxr.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        Nsx sp = nsxr.findByMa(ma);
        request.setAttribute("nsx", sp);
        request.setAttribute("view", "/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        Nsx sp = nsxr.findByMa(ma);
        nsxr.delete(sp);
        response.sendRedirect("/BaiTap_war/nsx/index");

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
            Nsx qlsp = new Nsx();
            BeanUtils.populate(qlsp, request.getParameterMap());
            nsxr.insert(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/nsx/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            Nsx qlsp = this.nsxr.findByMa(ma);
            BeanUtils.populate(qlsp, request.getParameterMap());
            nsxr.update(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/nsx/index");
    }
}


