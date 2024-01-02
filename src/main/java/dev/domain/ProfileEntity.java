package dev.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ProgrammerProfile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)  // Ensure uniqueness of email
    private String email;

    @Column
    private String password;

    @Column
    private String gitHubUsername;

    @Column(nullable = true)
    private String imageName;

    @Column
    private String photo;

    @Column
    private String bio;

    @Column
    private String contactInformation;

    @Column
    private String location;

    @Column
    private String socialMediaLinks;

    @Column
    private String education;

    @Column
    private String projects;

    @Column
    private Integer experiences;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "fk_programmer_user_unique"))
    private UsersEntity user;


    // Getters and Setters
    public ProfileEntity() {
    }

    // Constructor
    public ProfileEntity(Long id, String name, String email, String password, String gitHubUsername,
                         String imageName, String photo, String bio, String contactInformation,
                         String location, String socialMediaLinks, String education, String projects,
                         Integer experiences, UsersEntity user) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gitHubUsername = gitHubUsername;
        this.imageName = imageName;
        this.photo = photo;
        this.bio = bio;
        this.contactInformation = contactInformation;
        this.location = location;
        this.socialMediaLinks = socialMediaLinks;
        this.education = education;
        this.projects = projects;
        this.experiences = experiences;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGitHubUsername() {
        return gitHubUsername;
    }

    public void setGitHubUsername(String gitHubUsername) {
        this.gitHubUsername = gitHubUsername;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(String socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public Integer getExperiences() {
        return experiences;
    }

    public void setExperiences(Integer experiences) {
        this.experiences = experiences;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

//    public List<CertificationEntity> getProfile() {
//        return profile;
//    }
//
//    public void setProfile(List<CertificationEntity> profile) {
//        this.profile = profile;
//    }
}
