package dev.service;

import dev.domain.ProfileEntity;
import dev.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;


    public List<ProfileEntity> getAllProfiles() {
        return profileRepository.getAllProfiles();
    }

    public ProfileEntity getProfileById(Long id) {
        return profileRepository.getProfileById(id);
    }

    public void createProfile(ProfileEntity profile) {
        profileRepository.createProfile(profile);
    }

    public void updateProfile(ProfileEntity profile) {
        profileRepository.updateProfile(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteProfile(id);
    }
}
