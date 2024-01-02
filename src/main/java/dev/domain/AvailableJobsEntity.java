package dev.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "available_jobs")
public class AvailableJobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_email")
    private CompanyEntity company;

    @Column
    private String jobDescription;

    @Column
    private String jobRole;

    @Column
    private int jobSeat;

    @Column
    private Date jobExpireDate;

    @Column
    private Date joiningDate;

  
    @Column
    private String requiredSkills;

    @ManyToOne(fetch = FetchType.EAGER)
    private RecruiterEntity interviewer;

    @OneToMany(mappedBy = "availableJob", cascade = CascadeType.ALL)
    private List<AppliedJobsEntity> appliedJobs;

    // Getters and setters
    public AvailableJobsEntity(){}
    public AvailableJobsEntity(Long id, CompanyEntity company, String jobDescription,
                               String jobRole, int jobSeat, Date jobExpireDate,
                               Date joiningDate, String requiredSkills,
                               RecruiterEntity interviewer, List<AppliedJobsEntity> appliedJobs) {
        this.id = id;
        this.company = company;
        this.jobDescription = jobDescription;
        this.jobRole = jobRole;
        this.jobSeat = jobSeat;
        this.jobExpireDate = jobExpireDate;
        this.joiningDate = joiningDate;
        this.requiredSkills = requiredSkills;
        this.interviewer = interviewer;
        this.appliedJobs = appliedJobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public int getJobSeat() {
        return jobSeat;
    }

    public void setJobSeat(int jobSeat) {
        this.jobSeat = jobSeat;
    }

    public Date getJobExpireDate() {
        return jobExpireDate;
    }

    public void setJobExpireDate(Date jobExpireDate) {
        this.jobExpireDate = jobExpireDate;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public RecruiterEntity getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(RecruiterEntity interviewer) {
        this.interviewer = interviewer;
    }

    public List<AppliedJobsEntity> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<AppliedJobsEntity> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}
