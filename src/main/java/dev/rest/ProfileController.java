package dev.rest;

import dev.domain.ProfileEntity;
import dev.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<ProfileEntity> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ProfileEntity getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id);
    }

    @PostMapping
    public void createProfile(@RequestBody ProfileEntity profile) {
        profileService.createProfile(profile);
    }

    @PutMapping("/{id}")
    public void updateProfile(@PathVariable Long id, @RequestBody ProfileEntity profile) {
        profile.setId(id);
        profileService.updateProfile(profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
    }
}
