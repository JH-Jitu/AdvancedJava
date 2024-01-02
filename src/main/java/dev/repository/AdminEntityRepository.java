package dev.repository;

import dev.domain.AdminEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AdminEntityRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public AdminEntityRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<AdminEntity> getAllAdminEntities() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<AdminEntity> cq = cb.createQuery(AdminEntity.class);
        Root<AdminEntity> root = cq.from(AdminEntity.class);
        cq.select(root);
        Query<AdminEntity> query = session.createQuery(cq);
        return query.getResultList();
    }

    public void createAdminEntity(AdminEntity adminEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(adminEntity);
    }
}
