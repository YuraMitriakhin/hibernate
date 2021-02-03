package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.exception.DataProcessingException;
import com.gmail.yuramitryahin.lib.Dao;
import com.gmail.yuramitryahin.model.Ticket;
import com.gmail.yuramitryahin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert ticket " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
