package dev.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recruiter", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class RecruiterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String imageName;

    @Column
    private String photo;

   
    @Column
    String expertiseSkills;

   
    @Column
    private String projectLinks;

    @Column
    private String linkedInLink;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "fk_recruiter_user_unique"))
    private UsersEntity user;


    // Getters and setters
    public RecruiterEntity() {}
    // Constructor
    public RecruiterEntity(Long id, String name, String username, String email, String password,
                           String imageName, String photo, String expertiseSkills,
                           String projectLinks, String linkedInLink, UsersEntity user) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.imageName = imageName;
        this.photo = photo;
        this.expertiseSkills = expertiseSkills;
        this.projectLinks = projectLinks;
        this.linkedInLink = linkedInLink;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getExpertiseSkills() {
        return expertiseSkills;
    }

    public void setExpertiseSkills(String expertiseSkills) {
        this.expertiseSkills = expertiseSkills;
    }

    public String getProjectLinks() {
        return projectLinks;
    }

    public void setProjectLinks(String projectLinks) {
        this.projectLinks = projectLinks;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
