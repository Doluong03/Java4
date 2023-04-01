package DomainModel;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @ManyToOne()
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    @ManyToOne()
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "NgayShip")
    private Date ngayShip;
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    @Column(name = "TinhTrang")
    private int tinhTrang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "tongTien")
    private Double tongTien;
    @Column(name = "tienKh")
    private Double tienKh;

    public HoaDon() {
    }

    public HoaDon(UUID id, KhachHang khachHang, NhanVien nhanVien, String maHD, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt, Double tongTien, Double tienKh) {
        this.id = id;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        ma = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tongTien = tongTien;
        this.tienKh = tienKh;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaHD() {
        return ma;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getTienKh() {
        return tienKh;
    }

    public void setTienKh(Double tienKh) {
        this.tienKh = tienKh;
    }
}


