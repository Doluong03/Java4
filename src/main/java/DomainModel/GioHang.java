package DomainModel;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
public class GioHang {
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
    private String MaHD;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "TinhTrang")
    private int tinhTrang;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;

    public GioHang() {
    }

    public GioHang(UUID id, KhachHang khachHang, NhanVien nhanVien, String maHD, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, int tinhTrang, String diaChi, String sdt) {
        this.id = id;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        MaHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.tinhTrang = tinhTrang;
        this.diaChi = diaChi;
        this.sdt = sdt;
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
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
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
}


