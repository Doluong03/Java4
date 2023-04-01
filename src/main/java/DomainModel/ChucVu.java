package DomainModel;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="ChucVu")
public class ChucVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "chucVu")
    private List<NhanVien> listNv;

    public ChucVu() {
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<NhanVien> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVien> listNv) {
        this.listNv = listNv;
    }

    public ChucVu(UUID id, String ma, String ten, List<NhanVien> listNv) {
        Id = id;
        this.ma = ma;
        this.ten = ten;
        this.listNv = listNv;
    }
}


