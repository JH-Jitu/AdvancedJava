package dev.service;

import dev.domain.AdminEntity;
import dev.domain.UsersEntity;
import dev.repository.AdminEntityRepository;
import dev.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminEntityService {

    private final AdminEntityRepository adminEntityRepository;
    UsersRepository usersRepository;
    UsersService usersService;

    @Autowired
    public AdminEntityService(AdminEntityRepository adminEntityRepository) {
        this.adminEntityRepository = adminEntityRepository;
    }

    @Transactional
    public List<AdminEntity> getAllAdminEntities() {
        return adminEntityRepository.getAllAdminEntities();
    }

//    @Transactional
//    public ResponseEntity<String> createAdminEntity(AdminEntity adminEntity) {
//        try {
//            adminEntityRepository.createAdminEntity(adminEntity);
//            return ResponseEntity.status(HttpStatus.OK).body("Admin created successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create admin");
//        }
//    }

    @Transactional
    public ResponseEntity<String> createAdminEntity(AdminEntity adminEntity) {
        try {
            adminEntity.setUser(adminEntity.getUser());
            adminEntityRepository.createAdminEntity(adminEntity);

            // Create a corresponding user with admin's email and role="admin"
//            UsersEntity adminUser = new UsersEntity();
//            adminUser.setEmail(adminEntity.getEmail());
//            adminUser.setRole("admin");
////            System.out.println(adminUser);
////            usersService.createUser(adminUser);
//            usersRepository.save(adminUser);
            return ResponseEntity.status(HttpStatus.OK).body("Admin created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create admin");
        }
    }
}
