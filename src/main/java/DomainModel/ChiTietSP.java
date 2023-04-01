package DomainModel;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @ManyToOne()
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;
    @ManyToOne()
    @JoinColumn(name = "IdNsx")
    private Nsx nsx;
    @ManyToOne()
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    @ManyToOne()
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
    @Column(name = "NamBH")
    private int namBh;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "GiaNhap")
    private Double giaNhap;
    @Column(name = "GiaBan")
    private Double giaBan;
    @Column(name = "Anh")
    private String anh;

    public ChiTietSP() {
    }

    public ChiTietSP(UUID id, String ma, SanPham sanPham, Nsx nsx, MauSac mauSac, DongSP dongSP, int namBh, String moTa, int soLuongTon, Double giaNhap, Double giaBan, String anh) {
        this.id = id;
        this.ma = ma;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.anh = anh;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Nsx getNsx() {
        return nsx;
    }

    public void setNsx(Nsx nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public int getNamBh() {
        return namBh;
    }

    public void setNamBh(int namBh) {
        this.namBh = namBh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}


