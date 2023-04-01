package DomainModel;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="HoaDonChiTiet")
public class GioHangChiTIet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon IdHoaDon;

    @Id
    @ManyToOne()
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP IdChiTietSP;

//    @Column(name = "tongTienSP")
//    private Double tongTien;

    @Column(name = "SoLuong")
    private int SoLuong;

    @Column(name = "DonGia")
    private Double DonGia;

    @Column(name = "DonGiaKhiGiam")
    private Double DonGiaKhiGiam;

    public GioHangChiTIet() {
    }

    public GioHangChiTIet(HoaDon idHoaDon, ChiTietSP idChiTietSP, int soLuong, Double donGia, Double donGiaKhiGiam) {
        IdHoaDon = idHoaDon;
        IdChiTietSP = idChiTietSP;
        SoLuong = soLuong;
        DonGia = donGia;
        DonGiaKhiGiam = donGiaKhiGiam;
    }

    public HoaDon getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        IdHoaDon = idHoaDon;
    }

    public ChiTietSP getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSP idChiTietSP) {
        IdChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Double donGia) {
        DonGia = donGia;
    }

    public Double getDonGiaKhiGiam() {
        return DonGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(Double donGiaKhiGiam) {
        DonGiaKhiGiam = donGiaKhiGiam;
    }
}


