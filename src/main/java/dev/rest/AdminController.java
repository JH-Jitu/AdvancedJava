package dev.rest;

import dev.domain.AdminEntity;
import dev.service.AdminEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminEntityService adminEntityService;

    @Autowired
    public AdminController(AdminEntityService adminEntityService) {
        this.adminEntityService = adminEntityService;
    }

    // Read all Admin
    @GetMapping("/get-admins")
    public ResponseEntity<List<AdminEntity>> getAdmins() {
        List<AdminEntity> admins = adminEntityService.getAllAdminEntities();
        return ResponseEntity.ok(admins);
    }

    // Create Admin
    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody AdminEntity profile) {
        return adminEntityService.createAdminEntity(profile);
    }

    // Rest of the methods...
}
