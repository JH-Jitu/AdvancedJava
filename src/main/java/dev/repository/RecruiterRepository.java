package dev.repository;

import dev.domain.RecruiterEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RecruiterRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public RecruiterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public RecruiterEntity save(RecruiterEntity recruiterEntity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long recruiterId = (Long) session.save(recruiterEntity);
            session.getTransaction().commit();
            return recruiterEntity;
        }
    }

    @Transactional
    public RecruiterEntity findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<RecruiterEntity> query = session.createQuery("FROM RecruiterEntity WHERE email = :email", RecruiterEntity.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }

    @Transactional
    public List<RecruiterEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM RecruiterEntity", RecruiterEntity.class).list();
        }
    }

    @Transactional
    public void deleteByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM RecruiterEntity WHERE email = :email");
            query.setParameter("email", email);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    // Add additional methods as needed
}
