package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.exception.DataProcessingException;
import com.gmail.yuramitryahin.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> getAllSessionsByDate =
                    session.createQuery("SELECT ms FROM MovieSession ms "
                                    + " WHERE ms.movie.id = :movie_id "
                                    + "AND DATE_FORMAT(ms.showTime, '%Y-%m-%d') = :show_time ",
                            MovieSession.class);
            getAllSessionsByDate.setParameter("movie_id", movieId);
            getAllSessionsByDate.setParameter("show_time", date.toString());
            return getAllSessionsByDate.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find movie session by parameters id="
                    + movieId + " date=" + date, e);
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert movie session " + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update movie session " + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            MovieSession movieSession = session.load(MovieSession.class, id);
            session.delete(movieSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete movie session " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
