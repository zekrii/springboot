package com.vermeg.springboot.com.vermeg.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;

@Entity
public class GlobalExtraction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private long batchID;
    private Date startDate;
    private Date endDate;
    private double duration;



    public GlobalExtraction(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBatchID() {
        return batchID;
    }

    public void setBatchID(long batchID) {
        this.batchID = batchID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
