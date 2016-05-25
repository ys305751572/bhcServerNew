package com.leoman.feekback.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/5/25.
 */
@Entity
@Table(name = "image")
public class FeedbackImage extends BaseEntity{

    @Column(name = "path")
    private String path;

    @Column(name = "feekback_id")
    private String feekbackId;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFeekbackId() {
        return feekbackId;
    }

    public void setFeekbackId(String feekbackId) {
        this.feekbackId = feekbackId;
    }
}
