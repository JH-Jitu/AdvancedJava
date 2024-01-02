package dev.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interview_list", uniqueConstraints = @UniqueConstraint(columnNames = "applied_job_id"))
public class InterviewListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "applied_job_id")
    private AppliedJobsEntity appliedJob;

    @ManyToOne(fetch = FetchType.EAGER)
    private RecruiterEntity recruiter;

    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyEntity company;

    @Column(name = "google_meet_link")
    private String googleMeetLink;

    @Column(name = "date_time")
    private Date dateTime;

    // Getters and setters
    public InterviewListEntity(){}
    // Constructor
    public InterviewListEntity(Long id, AppliedJobsEntity appliedJob, RecruiterEntity recruiter,
                               CompanyEntity company, String googleMeetLink, Date dateTime) {
        this.id = id;
        this.appliedJob = appliedJob;
        this.recruiter = recruiter;
        this.company = company;
        this.googleMeetLink = googleMeetLink;
        this.dateTime = dateTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppliedJobsEntity getAppliedJob() {
        return appliedJob;
    }

    public void setAppliedJob(AppliedJobsEntity appliedJob) {
        this.appliedJob = appliedJob;
    }

    public RecruiterEntity getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(RecruiterEntity recruiter) {
        this.recruiter = recruiter;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getGoogleMeetLink() {
        return googleMeetLink;
    }

    public void setGoogleMeetLink(String googleMeetLink) {
        this.googleMeetLink = googleMeetLink;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
