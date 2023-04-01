package controller.admin;

import DomainModel.ChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/chuc-vu/index",    // GET
        "/chuc-vu/create",   // GET
        "/chuc-vu/edit",     // GET
        "/chuc-vu/delete",   // GET
        "/chuc-vu/store",    // POST
        "/chuc-vu/update",   // POST
})
public class ChucVuServlet extends HttpServlet {
    ChucVuRepository cvr = new ChucVuRepository();

    public ChucVuServlet() {
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
        request.setAttribute("view", "/views/chuc-vu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listSp", cvr.findAll());
        request.setAttribute("view", "/views/chuc-vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu sp = cvr.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/chuc-vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu sp = cvr.findByMa(ma);
        cvr.delete(sp);
        response.sendRedirect("/BaiTap_war/chuc-vu/index");

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println("asbdbasdb"+ma);
        String ten = request.getParameter("ten");
        if (ma == null || ma.trim().isEmpty()) {
            // Nếu mã sản phẩm không được nhập, hiển thị thông báo lỗi và ngăn chặn việc lưu trữ thông tin vào database
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin chức vụ .");
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            request.setAttribute("view", "/views/chuc-vu/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }

        if (ten == null || ten.trim().isEmpty()) {
            // Nếu tên sản phẩm không được nhập, hiển thị thông báo lỗi và ngăn chặn việc lưu trữ thông tin vào database
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin chức vụ ");
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            request.setAttribute("view", "/views/chuc-vu/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
            return;
        }
        try {
            ChucVu qlcv = new ChucVu();
            BeanUtils.populate(qlcv, request.getParameterMap());
            this.cvr.insert(qlcv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/chuc-vu/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChucVu qlcv = this.cvr.findByMa(ma);
            BeanUtils.populate(qlcv, request.getParameterMap());
            cvr.update(qlcv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/chuc-vu/index");
    }
}


