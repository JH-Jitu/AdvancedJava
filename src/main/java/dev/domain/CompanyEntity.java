package dev.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class CompanyEntity {

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
    private String ownerName;

    @Column(name = "license_no")
    private String licenseNo;

    @Column(name = "owner_nid")
    private String ownerNID;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<AvailableJobsEntity> availableJobs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "fk_company_user"))
    private UsersEntity user;

    // Getters and setters
    public CompanyEntity(){}
    public CompanyEntity(Long id, String name, String username, String email, String password,
                         String imageName, String photo, String ownerName, String licenseNo,
                         String ownerNID, List<AvailableJobsEntity> availableJobs, UsersEntity user) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.imageName = imageName;
        this.photo = photo;
        this.ownerName = ownerName;
        this.licenseNo = licenseNo;
        this.ownerNID = ownerNID;
        this.availableJobs = availableJobs;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getOwnerNID() {
        return ownerNID;
    }

    public void setOwnerNID(String ownerNID) {
        this.ownerNID = ownerNID;
    }

    public List<AvailableJobsEntity> getAvailableJobs() {
        return availableJobs;
    }

    public void setAvailableJobs(List<AvailableJobsEntity> availableJobs) {
        this.availableJobs = availableJobs;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}