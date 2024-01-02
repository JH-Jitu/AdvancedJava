package dev.domain;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nationalId;

    @Column
    private String imageName;

    @Column(nullable = false)
    @Lob
    private String photo;

//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String role;

//    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "admin_permissions", joinColumns = @JoinColumn(name = "admin_id"))
//    @Column(name = "permission", nullable = false)
//    @Enumerated(EnumType.STRING)
@Column(nullable = false)
    private String permissions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "fk_admin_user"))
    private UsersEntity user;


    // Getters and Setters
    public AdminEntity()
    {

    }
    public AdminEntity(Long id, String name, String username, String email, String password,
                       String nationalId, String imageName, String photo, String role,
                       String permissions, UsersEntity user) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nationalId = nationalId;
        this.imageName = imageName;
        this.photo = photo;
        this.role = role;
        this.permissions = permissions;
        this.user = user;
    }

    public AdminEntity(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }


}
