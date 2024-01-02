package dev.rest;

import dev.domain.CompanyEntity;
import dev.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCompanyEntity(@RequestBody CompanyEntity companyEntity) {
        try {
            companyService.createCompanyEntity(companyEntity);
            return ResponseEntity.ok("Company created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CompanyEntity>> getCompanies() {
        List<CompanyEntity> companies = companyService.getCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<CompanyEntity> getCompanyByEmail(@PathVariable String email) {
        CompanyEntity company = companyService.getCompanyByEmail(email);
        return ResponseEntity.ok(company);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteCompany(@PathVariable String email) {
        try {
            companyService.deleteCompany(email);
            return ResponseEntity.ok("Company deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

}
