package dev.repository;

import dev.domain.ProfileEntity;
import dev.domain.RecruiterEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProfileRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//    public List<ProfileEntity> getAllProfiles() {
//        CriteriaBuilder builder = getSession().getCriteriaBuilder();
//        CriteriaQuery<ProfileEntity> criteria = builder.createQuery(ProfileEntity.class);
//        Root<ProfileEntity> root = criteria.from(ProfileEntity.class);
//        criteria.select(root);
//        return getSession().createQuery(criteria).getResultList();
//    }

    @Transactional
    public List<ProfileEntity> getAllProfiles() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM ProfileEntity", ProfileEntity.class).list();
        }
    }

    public ProfileEntity getProfileById(Long id) {
        return getSession().get(ProfileEntity.class, id);
    }

    public void createProfile(ProfileEntity profile) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long recruiterId = (Long) session.save(profile);
            session.getTransaction().commit();
        }

    }

    @Transactional
    public void updateProfile(ProfileEntity profile) {
        getSession().update(profile);
    }

    @Transactional
    public void deleteProfile(Long id) {
        ProfileEntity profile = getProfileById(id);
        if (profile != null) {
            getSession().delete(profile);
        }
    }
}
