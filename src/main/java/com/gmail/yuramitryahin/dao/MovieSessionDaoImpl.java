package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.exception.DataProcessingException;
import com.gmail.yuramitryahin.lib.Dao;
import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
            session = HibernateUtil.getSessionFactory().openSession();
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
}
