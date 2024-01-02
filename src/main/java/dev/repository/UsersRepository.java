package dev.repository;

import dev.domain.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UsersRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UsersRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public UsersEntity findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<UsersEntity> query = session.createQuery("FROM UsersEntity WHERE email = :email", UsersEntity.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }

    @Transactional
    public UsersEntity save(UsersEntity user) {
        Session session = sessionFactory.getCurrentSession();
            System.out.println("its running");
            System.out.println(user.getEmail());

            System.out.println(user.getRole());
            session.persist(user);

            return user;
    }

    @Transactional
    public void delete(UsersEntity user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}
