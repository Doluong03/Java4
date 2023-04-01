package repositories;

import DomainModel.ChiTietSP;
import DomainModel.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HIbernateUtils;
import viewModel.QLChiTietSP;
import viewModel.QLHoaDonCT;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSpRepository {
    private ArrayList<QLChiTietSP> list;
    private ArrayList<QLHoaDonCT> list2 ;
    private Session hSession;
    public ChiTietSpRepository()
    {
        this.list = new ArrayList<>();
        this.list2 = new ArrayList<>();
        this.hSession = HIbernateUtils.getFACTORY().openSession();
    }


    public void insert(ChiTietSP chiTietSP)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSP chiTietSP)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSP chiTietSP)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void addCart( QLHoaDonCT qlct, ArrayList<QLHoaDonCT> List,QLChiTietSP chiTietSP) {
        boolean found  = false;
        for (QLHoaDonCT x : List) {
            if (x.getMa_ct().equals(qlct.getMa_ct())) {
                x.setSo_luong(x.getSo_luong() + 1);
                x.setTong_tien(x.getDon_gia()*x.getSo_luong());
                found = true;
                break;
            }
        }

        if (!found) {
            List.add(qlct);
        }
    }

    public List<ChiTietSP> findAll()
    {
        String hql = "SELECT obj FROM ChiTietSP obj";
        Query<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        return query.getResultList();
    }

    public ChiTietSP findByMa(String ma)
    {
        String hql = "SELECT obj FROM ChiTietSP obj WHERE obj.ma = ?1";
        Query<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }

    public QLHoaDonCT findByMa2(String ma , ArrayList<QLHoaDonCT> List) {
        for (int i = 0; i < List.size(); i++) {
            QLHoaDonCT x = List.get(i);
            if (x.getMa_ct().equals(ma)) {
                return List.get(i);
            }
        }
        return null;
    }
}
