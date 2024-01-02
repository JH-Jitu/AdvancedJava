package dev.rest;

import dev.domain.AvailableJobsEntity;
import dev.service.AvailableJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/available-jobs")
public class AvailableJobsController {

    @Autowired
    private AvailableJobsService availableJobsService;


    @GetMapping
    public List<AvailableJobsEntity> getAllAvailableJobs() {
        return availableJobsService.getAllAvailableJobs();
    }

    @GetMapping("/{id}")
    public AvailableJobsEntity getAvailableJobById(@PathVariable Long id) {
        return availableJobsService.getAvailableJobById(id);
    }

    @PostMapping
    public void createAvailableJob(@RequestBody AvailableJobsEntity availableJob) {
        availableJobsService.createAvailableJob(availableJob);
    }

    @PutMapping("/{id}")
    public void updateAvailableJob(@PathVariable Long id, @RequestBody AvailableJobsEntity availableJob) {
        availableJob.setId(id);
        availableJobsService.updateAvailableJob(availableJob);
    }

    @DeleteMapping("/{id}")
    public void deleteAvailableJob(@PathVariable Long id) {
        availableJobsService.deleteAvailableJob(id);
    }
}
