package repositories;

import controller.DBConnection;
import viewModel.QLHoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoaDonRepository {
    private ArrayList<QLHoaDon> list;

    public HoaDonRepository() {
        this.list = new ArrayList<>();
    }

    public void insert(QLHoaDon qlhd) {
        this.getList().add(qlhd);
    }

    public void update(QLHoaDon qlhd) {
        for (int i = 0; i < this.getList().size(); i++) {
            QLHoaDon x = this.getList().get(i);
            if (x.getMa().equals(qlhd.getMa())) {
                this.getList().set(i, qlhd);
            }
        }
    }

    public void delete(QLHoaDon qlhd) {
        for (int i = 0; i < this.getList().size(); i++) {
            QLHoaDon x = this.getList().get(i);
            if (x.getMa().equals(qlhd.getMa())) {
                this.getList().remove(i);
            }
        }
    }

//    public ArrayList<QLHoaDon> getList() {
//        return this.list;
//    }
DBConnection connection ;
    public ArrayList<QLHoaDon> getList() {
        ArrayList<QLHoaDon> listCh = new ArrayList<>();
        String sql = "SELECT " +
                "      [IdKH]\n" +
                "      ,[IdNV]\n" +
                "      ,[Ma]\n" +
                "      ,[NgayTao]\n" +
                "      ,[NgayThanhToan]\n" +
                "      ,[NgayShip]\n" +
                "      ,[NgayNhan]\n" +
                "      ,[TinhTrang]\n" +
                "      ,[TenNguoiNhan]\n" +
                "      ,[DiaChi]\n" +
                "      ,[Sdt]\n" +
                "  FROM [dbo].[HoaDon]";
        try (Connection con = connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLHoaDon qlhd = new QLHoaDon();
                qlhd.setKhach_hang(rs.getString(1));
                qlhd.setNhan_vien(rs.getString(2));
                qlhd.setMa(rs.getString(3));
                qlhd.setNgay_tao(rs.getString(4));
                qlhd.setNgay_thanh_toan(rs.getString(5));
                qlhd.setNgay_ship(rs.getString(6));
                qlhd.setNgay_nhan(rs.getString(7));
                qlhd.setTinh_trang(rs.getString(8));
                qlhd.setNguoi_nhan(rs.getString(9));
                qlhd.setDia_chi(rs.getString(10));
                qlhd.setSdt(rs.getString(11));
                listCh.add(qlhd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCh;
    }

    public QLHoaDon findByMa(String ma) {
        for (int i = 0; i < this.getList().size(); i++) {
            QLHoaDon x = this.getList().get(i);
            if (x.getMa().equals(ma)) {
                return this.getList().get(i);
            }
        }
        return null;
    }

}
