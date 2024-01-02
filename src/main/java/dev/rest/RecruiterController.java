package dev.rest;

import dev.domain.RecruiterEntity;
import dev.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recruiters")
public class RecruiterController {

    private final RecruiterService recruiterService;

    @Autowired
    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping("/create")
    public ResponseEntity<RecruiterEntity> createRecruiter(@RequestBody RecruiterEntity recruiterEntity) {
        RecruiterEntity createdRecruiter = recruiterService.createRecruiter(recruiterEntity);
        return ResponseEntity.ok(createdRecruiter);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<RecruiterEntity> getRecruiterByEmail(@PathVariable String email) {
        RecruiterEntity recruiter = recruiterService.getRecruiterByEmail(email);
        return ResponseEntity.ok(recruiter);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RecruiterEntity>> getAllRecruiters() {
        List<RecruiterEntity> recruiters = recruiterService.getAllRecruiters();
        return ResponseEntity.ok(recruiters);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteRecruiterByEmail(@PathVariable String email) {
        recruiterService.deleteRecruiterByEmail(email);
        return ResponseEntity.ok("Recruiter deleted successfully");
    }

}
