package dev.service;

import dev.domain.RecruiterEntity;
import dev.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    @Autowired
    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public RecruiterEntity createRecruiter(RecruiterEntity recruiterEntity) {
        // Perform any necessary validation or business logic before saving
        return recruiterRepository.save(recruiterEntity);
    }

    public RecruiterEntity getRecruiterByEmail(String email) {
        return recruiterRepository.findByEmail(email);
    }

    public List<RecruiterEntity> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    public void deleteRecruiterByEmail(String email) {
        recruiterRepository.deleteByEmail(email);
    }

    // Add additional service methods as needed
}
