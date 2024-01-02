package dev.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.domain.UsersEntity;
import dev.repository.UsersRepository;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public UsersEntity createUser(UsersEntity userDTO) {
        UsersEntity user = new UsersEntity();
        user.setEmail(userDTO.getEmail());
        String email = userDTO.getEmail();
        String role = userDTO.getRole();
        System.out.println(userDTO.getEmail());

        System.out.println(userDTO.getRole());
        System.out.println("its running");
        // Set other properties...
        return usersRepository.save(userDTO);
    }

    @Transactional
    public ResponseEntity<String> deleteUserByEmail(String email) {
        UsersEntity user = usersRepository.findByEmail(email);
        if (user != null) {
            usersRepository.delete(user);
        }
        return null;
    }
}
