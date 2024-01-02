package dev.service;

import dev.domain.AvailableJobsEntity;
import dev.repository.AvailableJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableJobsService {

    @Autowired
    private AvailableJobsRepository availableJobsRepository;

    public List<AvailableJobsEntity> getAllAvailableJobs() {
        return availableJobsRepository.getAllAvailableJobs();
    }

    public AvailableJobsEntity getAvailableJobById(Long id) {
        return availableJobsRepository.getAvailableJobById(id);
    }

    public void createAvailableJob(AvailableJobsEntity availableJob) {
        availableJobsRepository.createAvailableJob(availableJob);
    }

    public void updateAvailableJob(AvailableJobsEntity availableJob) {
        availableJobsRepository.updateAvailableJob(availableJob);
    }

    public void deleteAvailableJob(Long id) {
        availableJobsRepository.deleteAvailableJob(id);
    }
}
