package viewModel;

public class QLHoaDonCT {
    private String ma_ct;
    private String ma_sp;
    private String ma_hd;
    private String ten_sp;
    private int so_luong;
    private double don_gia;
    private double tong_tien;

    public QLHoaDonCT() {
    }

    public QLHoaDonCT(QLChiTietSP chiTietSP, int so_luong, QLHoaDon qlHoaDon) {
        this.ma_ct = chiTietSP.getMa();
        this.ma_sp =chiTietSP.getSan_pham();
        this.ma_hd= qlHoaDon.getMa();
        this.ten_sp =chiTietSP.getSan_pham();
        this.so_luong = so_luong;
        this.don_gia = chiTietSP.getGia_ban();
        this.tong_tien= Double.parseDouble(String.valueOf(so_luong)) * this.don_gia ;
    }

    public String getMa_ct() {
        return ma_ct;
    }

    public void setMa_ct(String ma_ct) {
        this.ma_ct = ma_ct;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public String getMa_hd() {
        return ma_hd;
    }

    public void setMa_hd(String ma_hd) {
        this.ma_hd = ma_hd;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(double don_gia) {
        this.don_gia = don_gia;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }
}


