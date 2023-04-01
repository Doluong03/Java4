package viewModel;

public class QLHoaDon {
        private String ma;
        private String khach_hang;
        private String nhan_vien;
        private String ngay_tao;
        private String ngay_thanh_toan;
        private String ngay_ship;
        private String ngay_nhan;
        private String tinh_trang;
        private String nguoi_nhan   ;
        private String dia_chi;
        private String sdt;
        private double tong_tien;

        public QLHoaDon() {
        }

    public QLHoaDon(String ma, String khach_hang, String nhan_vien, String ngay_tao, String ngay_thanh_toan, String ngay_ship, String ngay_nhan, String tinh_trang, String nguoi_nhan, String sdt, String dia_chi,double tong_tien) {
        this.ma = ma;
        this.khach_hang = khach_hang;
        this.nhan_vien = nhan_vien;
        this.ngay_tao = ngay_tao;
        this.ngay_thanh_toan = ngay_thanh_toan;
        this.ngay_ship = ngay_ship;
        this.ngay_nhan = ngay_nhan;
        this.tinh_trang = tinh_trang;
        this.nguoi_nhan = nguoi_nhan;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.tong_tien = tong_tien;

    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getKhach_hang() {
        return khach_hang;
    }

    public void setKhach_hang(String khach_hang) {
        this.khach_hang = khach_hang;
    }

    public String getNhan_vien() {
        return nhan_vien;
    }

    public void setNhan_vien(String nhan_vien) {
        this.nhan_vien = nhan_vien;
    }

    public String getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(String ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public String getNgay_thanh_toan() {
        return ngay_thanh_toan;
    }

    public void setNgay_thanh_toan(String ngay_thanh_toan) {
        this.ngay_thanh_toan = ngay_thanh_toan;
    }

    public String getNgay_ship() {
        return ngay_ship;
    }

    public void setNgay_ship(String ngay_ship) {
        this.ngay_ship = ngay_ship;
    }

    public String getNgay_nhan() {
        return ngay_nhan;
    }

    public void setNgay_nhan(String ngay_nhan) {
        this.ngay_nhan = ngay_nhan;
    }

    public String getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(String tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public String getNguoi_nhan() {
        return nguoi_nhan;
    }

    public void setNguoi_nhan(String nguoi_nhan) {
        this.nguoi_nhan = nguoi_nhan;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }
}


