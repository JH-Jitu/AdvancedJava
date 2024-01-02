package dev.rest;

import dev.domain.UsersEntity;
import dev.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users") // Changed the base path to avoid conflict
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public UsersEntity createUser(@RequestBody UsersEntity profile) {
        return usersService.createUser(profile);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        return usersService.deleteUserByEmail(email);
    }
}
