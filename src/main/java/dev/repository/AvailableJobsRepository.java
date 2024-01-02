package dev.repository;

import dev.domain.AvailableJobsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AvailableJobsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//    public List<AvailableJobsEntity> getAllAvailableJobs() {
//        CriteriaBuilder builder = getSession().getCriteriaBuilder();
//        CriteriaQuery<AvailableJobsEntity> criteria = builder.createQuery(AvailableJobsEntity.class);
//        Root<AvailableJobsEntity> root = criteria.from(AvailableJobsEntity.class);
//        criteria.select(root);
//        return getSession().createQuery(criteria).getResultList();
//    }

    @Transactional
    public List<AvailableJobsEntity> getAllAvailableJobs() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM AvailableJobsEntity", AvailableJobsEntity.class).list();
        }
    }

    public AvailableJobsEntity getAvailableJobById(Long id) {
        return getSession().get(AvailableJobsEntity.class, id);
    }

//    public void createAvailableJob(AvailableJobsEntity availableJob) {
//        getSession().save(availableJob);
//    }

    @Transactional
    public void createAvailableJob(AvailableJobsEntity availableJob) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long recruiterId = (Long) session.save(availableJob);
            session.getTransaction().commit();
        }
    }

    @Transactional
    public void updateAvailableJob(AvailableJobsEntity availableJob) {
        getSession().update(availableJob);
    }

    @Transactional
    public void deleteAvailableJob(Long id) {
        AvailableJobsEntity availableJob = getAvailableJobById(id);
        if (availableJob != null) {
            getSession().delete(availableJob);
        }
    }
}
