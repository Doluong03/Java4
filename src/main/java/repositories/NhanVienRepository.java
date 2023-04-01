package repositories;

import DomainModel.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HIbernateUtils;
import viewModel.QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private ArrayList<QLNhanVien> list;
    private Session hSession;

    public NhanVienRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HIbernateUtils.getFACTORY().openSession();
    }

    public void insert(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien findById(String id)
    {
        return this.hSession.find(NhanVien.class, id);
    }

    public List<NhanVien> findAll()
    {
        String hql = "SELECT obj FROM NhanVien obj";
        Query<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        return query.getResultList();
    }

    public NhanVien findByMa(String ma)
    {
        String hql = "SELECT obj FROM NhanVien obj WHERE obj.ma = ?1";
        Query<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }

}
