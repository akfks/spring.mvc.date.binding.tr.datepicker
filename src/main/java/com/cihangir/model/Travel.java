package com.cihangir.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cihangir on 6/26/17.
 */
@Entity
@Table(name = "travel")
public class Travel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String purpose;
    private String projectCode;

//      @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "begin_time")
    @Temporal (TemporalType.DATE)
//    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date beginTime;

    //    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "end_time")
    @Temporal (TemporalType.DATE)
//    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
