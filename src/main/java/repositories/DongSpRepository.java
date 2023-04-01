package repositories;

import DomainModel.DongSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HIbernateUtils;
import viewModel.QLDongSp;

import java.util.ArrayList;
import java.util.List;

public class DongSpRepository {
    private ArrayList<QLDongSp> list;
    private Session hSession;
    public DongSpRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HIbernateUtils.getFACTORY().openSession();
    }

    public void insert(DongSP dsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(DongSP dsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSP dsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public DongSP findById(String id)
    {
        return this.hSession.find(DongSP.class, id);
    }

    public List<DongSP> findAll()
    {
        String hql = "SELECT obj FROM DongSP obj";
        Query<DongSP> query = this.hSession.createQuery(hql, DongSP.class);
        return query.getResultList();
    }

    public DongSP findByMa(String ma)
    {
        String hql = "SELECT obj FROM DongSP obj WHERE obj.ma = ?1";
        Query<DongSP> query = this.hSession.createQuery(hql, DongSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
