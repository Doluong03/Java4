package viewModel;

import java.text.DecimalFormat;

public class QLChiTietSP {
        private String ma;
        private String san_pham;
        private String nsx;
        private String mau_sac;
        private String dong_sp;
        private int nam_bh;
        private String mo_ta;
        private int so_luong_ton;
        private Double gia_nhap;
        private Double gia_ban;

        public QLChiTietSP() {
        }

    public QLChiTietSP(String ma, String san_pham, String nsx, String mau_sac, String dong_sp, int nam_bh, String mo_ta, int so_luong_ton, Double gia_nhap, Double gia_ban) {
        this.ma = ma;
        this.san_pham = san_pham;
        this.nsx = nsx;
        this.mau_sac = mau_sac;
        this.dong_sp = dong_sp;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.so_luong_ton = so_luong_ton;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSan_pham() {
        return san_pham;
    }

    public void setSan_pham(String san_pham) {
        this.san_pham = san_pham;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getMau_sac() {
        return mau_sac;
    }

    public void setMau_sac(String mau_sac) {
        this.mau_sac = mau_sac;
    }

    public String getDong_sp() {
        return dong_sp;
    }

    public void setDong_sp(String dong_sp) {
        this.dong_sp = dong_sp;
    }

    public int getNam_bh() {
        return nam_bh;
    }

    public void setNam_bh(int nam_bh) {
        this.nam_bh = nam_bh;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getSo_luong_ton() {
        return so_luong_ton;
    }

    public void setSo_luong_ton(int so_luong_ton) {
        this.so_luong_ton = so_luong_ton;
    }

    public Double getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(Double gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public Double getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(Double gia_ban) {
        this.gia_ban = gia_ban;
    }
}


