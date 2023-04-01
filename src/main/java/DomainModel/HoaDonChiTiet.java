package DomainModel;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon IdHoaDon;

    @Id
    @ManyToOne()
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP IdChiTietSP;

    @Column(name = "tongTienSP")
    private Double tongTien;

    @Column(name = "SoLuong")
    private int SoLuong;

    @Column(name = "DonGia")
    private Double DonGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon idHoaDon, ChiTietSP idChiTietSP, Double tongTien, int soLuong, Double donGia) {
        IdHoaDon = idHoaDon;
        IdChiTietSP = idChiTietSP;
        this.tongTien = tongTien;
        SoLuong = soLuong;
        DonGia = donGia;
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

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
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
}


