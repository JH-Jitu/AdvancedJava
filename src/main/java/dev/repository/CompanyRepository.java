package dev.repository;

import dev.domain.CompanyEntity;
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
public class CompanyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void createCompanyEntity(CompanyEntity companyEntity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long recruiterId = (Long) session.save(companyEntity);
            session.getTransaction().commit();
        }
    }

    public List<CompanyEntity> getCompanies() {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<CompanyEntity> criteriaQuery = builder.createQuery(CompanyEntity.class);
        Root<CompanyEntity> root = criteriaQuery.from(CompanyEntity.class);
        criteriaQuery.select(root);
        Query<CompanyEntity> query = getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    public CompanyEntity getCompanyByEmail(String email) {
        return getCurrentSession().byId(CompanyEntity.class).load(email);
    }

    public void deleteCompany(String email) {
        CompanyEntity companyEntity = getCurrentSession().byId(CompanyEntity.class).load(email);
        getCurrentSession().delete(companyEntity);
    }


    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
