package controller.admin;

import org.apache.commons.beanutils.BeanUtils;
import repositories.HoaDonRepository;
import viewModel.QLHoaDon;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import viewModel.QLKhachHang;

@WebServlet({
        "/hoa-don/index",    // GET
        "/hoa-don/create",   // GET
        "/hoa-don/edit",     // GET
        "/hoa-don/delete",   // GET
        "/hoa-don/store",    // POST
        "/hoa-don/update",   // POST
})
public class HoaDonServlet extends HttpServlet {
    HoaDonRepository hdr = new HoaDonRepository();

    public HoaDonServlet() {
      // hdr.getList().add(new QLHoaDon("ma", "khach_hang", "nhan_vien", "ngay_tao", "ngay_thanh_toan", "ngay_ship", "ngay_nhan", "tinh_trang", "nguoi_nhan", "dia_chi", "sdt"));
    }
    public ArrayList<QLHoaDon> getList(){
        return this.hdr.getList();
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
        request.setAttribute("view", "/views/hoa-don/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listHd", this.hdr.getList());
        request.setAttribute("view", "/views/hoa-don/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon hd = hdr.findByMa(ma);
        hdr.delete(hd);
        response.sendRedirect("/BaiTap_war/hoa-don/index");

    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon hd = hdr.findByMa(ma);
        request.setAttribute("hd", hd);
        request.setAttribute("view", "/views/hoa-don/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLHoaDon qlhd = new QLHoaDon();
            BeanUtils.populate(qlhd, request.getParameterMap());
            hdr.insert(qlhd);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/BaiTap_war/hoa-don/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLHoaDon qlhd = new QLHoaDon();
            BeanUtils.populate(qlhd, request.getParameterMap());
            hdr.update(qlhd);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BaiTap_war/hoa-don/index");
    }
}


