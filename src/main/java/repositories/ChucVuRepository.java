package repositories;

import DomainModel.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HIbernateUtils;


import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    private Session hSession;
    public ChucVuRepository()
    {

        this.hSession = HIbernateUtils.getFACTORY().openSession();
    }

    public void insert(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChucVu findById(String id)
    {
        return this.hSession.find(ChucVu.class, id);
    }

    public List<ChucVu> findAll()
    {
        String hql = "SELECT obj FROM ChucVu obj";
        Query<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(String ma)
    {
        String hql = "SELECT obj FROM ChucVu obj WHERE obj.ma = ?1";
        Query<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
