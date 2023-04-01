package repositories;

import DomainModel.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HIbernateUtils;
import viewModel.QLMauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private ArrayList<QLMauSac> list;
    private Session hSession;
    public MauSacRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HIbernateUtils.getFACTORY().openSession();
    }

    public void insert(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac findById(String id)
    {
        return this.hSession.find(MauSac.class, id);
    }

    public List<MauSac> findAll()
    {
        String hql = "SELECT obj FROM MauSac obj";
        Query<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(String ma)
    {
        String hql = "SELECT obj FROM MauSac obj WHERE obj.ma = ?1";
        Query<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
