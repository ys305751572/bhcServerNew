package com.leoman.complaint.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.doctor.entity.Doctor;
import com.leoman.user.entity.AolUser;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/5/26.
 */
@Entity
@Table(name = "complaint")
public class Complaint extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AolUser user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String content;

    public AolUser getUser() {
        return user;
    }

    public void setUser(AolUser user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
