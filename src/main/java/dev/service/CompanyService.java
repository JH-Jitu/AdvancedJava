package dev.service;

import dev.domain.CompanyEntity;
import dev.repository.CompanyRepository;
import dev.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, UsersRepository usersRepository) {
        this.companyRepository = companyRepository;
        this.usersRepository = usersRepository;
    }

    public void createCompanyEntity(CompanyEntity companyEntity) {
        // Check if the email already exists in the users table
        if (usersRepository.findByEmail(companyEntity.getEmail()) != null) {
            throw new RuntimeException("Email address is already in use");
        }

        // If the email doesn't exist, proceed to create company and user entities
        companyRepository.createCompanyEntity(companyEntity);
    }

    public List<CompanyEntity> getCompanies() {
        return companyRepository.getCompanies();
    }

    public CompanyEntity getCompanyByEmail(String email) {
        return companyRepository.getCompanyByEmail(email);
    }

    public void deleteCompany(String email) {
        companyRepository.deleteCompany(email);
    }

}
