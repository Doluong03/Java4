package repositories;

import controller.DBConnection;
import viewModel.QLChiTietSP;
import viewModel.QLHoaDon;
import viewModel.QLHoaDonCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import java.util.ArrayList;

public class MuaHangRepository {
    private ArrayList<QLChiTietSP> list;
    private ArrayList<QLHoaDonCT> list2;

    public MuaHangRepository() {
        this.list = new ArrayList<>();
        this.list2 = new ArrayList<>();
    }

    public QLHoaDon taoHD(ArrayList<QLHoaDon> List, QLHoaDon qlhd) {
        boolean found = false;
        for (QLHoaDon x : List
        ) {
            if (x.getMa().equals(qlhd.getMa())) {
                found = true;
                System.out.println("Trung ma");
                break;
            }
        }
        if (!found) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(9000) + 1000;
            qlhd = new QLHoaDon("HD" + randomNumber, null, null, LocalDate.now().toString(), LocalDate.now().toString(), null, null, null, null, null, null, 0);
            return qlhd;
        }
        return null;
    }

    DBConnection connection;

    public QLHoaDon addCh(QLHoaDon ch) {
        String sql = "INSERT INTO [dbo].[HoaDon]\n" +
                "           (        [Ma]\n" +
                "           ,[NgayTao]\n" +
                "           ,[NgayThanhToan]\n" +
                "           ,[NgayShip]\n" +
                "           ,[NgayNhan]\n" +
                "           ,[TinhTrang]\n" +
                "           ,[TenNguoiNhan]\n" +
                "           ,[DiaChi]\n" +
                "           ,[Sdt])\n" +
                "     values(?,?,?,?,?,?,?,?,?)";
        try (Connection con = connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getNgay_tao());
            ps.setObject(3, ch.getNgay_thanh_toan());
            ps.setObject(4, ch.getNgay_ship());
            ps.setObject(5, ch.getNgay_nhan());
            ps.setObject(6, ch.getTinh_trang());
            ps.setObject(7, ch.getNguoi_nhan());
            ps.setObject(8, ch.getDia_chi());
            ps.setObject(9, ch.getSdt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    public QLHoaDon update(QLHoaDon ch, String ma) {
        String sql = "UPDATE [dbo].[HoaDon]\n" +
                "   SET [IdKH] = ?\n" +
                "      ,[IdNV] = ? \n" +
                ",[NgayTao] = ? \n" +
                "      ,[NgayThanhToan] = ? \n" +
                "      ,[NgayShip] = ? \n" +
                "      ,[NgayNhan] = ? \n" +
                "      ,[TinhTrang] = ? \n" +
                "      ,[TenNguoiNhan] = ? \n" +
                "      ,[DiaChi] = ? \n" +
                "      ,[Sdt] = ? \n" +
                "      ,[tongTien] = ? \n" +
                " WHERE [Ma] = ?";
        try (Connection con = connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ch.getKhach_hang());
            ps.setObject(2, ch.getNhan_vien());
            ps.setObject(3, ch.getNgay_tao());
            ps.setObject(4, ch.getNgay_thanh_toan());
            ps.setObject(5, ch.getNgay_ship());
            ps.setObject(6, ch.getNgay_nhan());
            ps.setObject(7, ch.getTinh_trang());
            ps.setObject(8, ch.getNguoi_nhan());
            ps.setObject(9, ch.getDia_chi());
            ps.setObject(10, ch.getSdt());
            ps.setObject(11, ch.getTong_tien());
            ps.setObject(12, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }
}
