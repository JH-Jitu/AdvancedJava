package dev.domain;

import javax.persistence.*;

@Entity
@Table(name = "applied_jobs", uniqueConstraints = @UniqueConstraint(columnNames = {"available_job_id", "programmer_id"}))
public class AppliedJobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "available_job_id")
    private AvailableJobsEntity availableJob;

    @ManyToOne
    @JoinColumn(name = "programmer_id")
    private ProfileEntity programmer;

    @Column
    private String companyEmail;

    // Getters and setters
    public AppliedJobsEntity(){}
    public AppliedJobsEntity(Long id, AvailableJobsEntity availableJob, ProfileEntity programmer, String companyEmail) {
        this.id = id;
        this.availableJob = availableJob;
        this.programmer = programmer;
        this.companyEmail = companyEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AvailableJobsEntity getAvailableJob() {
        return availableJob;
    }

    public void setAvailableJob(AvailableJobsEntity availableJob) {
        this.availableJob = availableJob;
    }

    public ProfileEntity getProgrammer() {
        return programmer;
    }

    public void setProgrammer(ProfileEntity programmer) {
        this.programmer = programmer;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
