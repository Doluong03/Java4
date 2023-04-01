package controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChiTietSpRepository;
import repositories.HoaDonRepository;
import repositories.MuaHangRepository;
import viewModel.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MuaHangServlet", value = "/")
public class MuaHangServlet extends HttpServlet {
    private ChiTietSpRepository ctsr = new ChiTietSpRepository();
    private HoaDonRepository hdr = new HoaDonRepository();
    ArrayList<QLHoaDonCT> ListOut = new ArrayList<>();
    ArrayList<QLHoaDon> ListHD = hdr.getList();
    private MuaHangRepository mhr = new MuaHangRepository();

    public MuaHangServlet() {
        QLSanPham sp = new QLSanPham("SP", "TH true milk");
        QLNsx nsx = new QLNsx("nsx1", "NSX_A");
        QLDongSp dsp = new QLDongSp("dsp1", "DSP_A");
        QLMauSac ms = new QLMauSac("ms1", "MS_A");
//        ctsr.findAll().add(new QLChiTietSP("SP1", "TH true milk 1", "NSX_A", "MS_A", "DSP_A", 3, "None", 3, 3000.0, 3000.00));
//        ctsr.getList().add(new QLChiTietSP("SP2", "TH true milk 2", "NSX_B", "MS_B", "DSP_B", 2, "None", 23, 3000.0, 5000.00));
//        ctsr.getList().add(new QLChiTietSP("SP3", "TH true milk 3", "NSX_V", "MS_C", "DSP_C", 1, "None", 12, 3000.0, 7000.00));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("index2")) {
//            this.index2(request, response);
        } else if (uri.contains("edit")) {
//            this.edit(request, response);
        } else if (uri.contains("delete")) {
//            this.delete(request, response);
        } else if (uri.contains("thanhToan")) {
//            this.thanhToan(request, response);
        } else {
            this.index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.update(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listCt", ctsr.findAll());
        request.setAttribute("view", "/views/muaHang.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }


//    protected void edit(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
////        QLChiTietSP qlct = this.ctsr.findByMa(ma);
//        System.out.println(ListHD.size());
//        if (ListOut.isEmpty()) {
//            QLHoaDon hd = mhr.taoHD(ListHD, new QLHoaDon());
//            mhr.addCh(hd);
//            QLHoaDonCT qlhd = new QLHoaDonCT(qlct, 1, hd);
//            ctsr.addCart(qlhd, ListOut, qlct);
//        } else {
//           QLHoaDon hd= hdr.findByMa(ListOut.get(0).getMa_hd());
//            QLHoaDonCT qlhd = new QLHoaDonCT(qlct, 1, hd);
//            ctsr.addCart(qlhd, ListOut, qlct);
//        }
//        request.setAttribute("ct", qlct);
//        response.sendRedirect("/BaiTap_war//index2");
//
//    }

//    protected void index2(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        request.setAttribute("listCt2", ListOut);
//        request.setAttribute("view", "/views/thanhToan.jsp");
//        request.getRequestDispatcher("/views/layout.jsp")
//                .forward(request, response);
//    }
//
//    protected void delete(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        QLHoaDonCT qlct = this.ctsr.findByMa2(ma, ListOut);
////        System.out.println(qlct.getMa_ct());
//        ListOut.remove(qlct);
//        response.sendRedirect("/BaiTap_war//index2");
//    }
//    protected void thanhToan(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        double total = Double.parseDouble(request.getParameter("total"));
//        System.out.println(total);
//        System.out.println(ma);
//        QLHoaDon hd = hdr.findByMa(ma);
//        request.setAttribute("hd", hd);
//        hd.setTong_tien(total);
//        request.setAttribute("view", "/views/tt.jsp");
//        request.getRequestDispatcher("/views/layout.jsp")
//                .forward(request, response);
//    }
//    protected void update(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        try {
//            QLHoaDon qlkh = new QLHoaDon();
//            BeanUtils.populate(qlkh, request.getParameterMap());
//            mhr.update(qlkh,qlkh.getMa());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        // Tạo ArrayList & thêm vào
//        response.sendRedirect("/BaiTap_war/hoa-don/index");
//    }
}
