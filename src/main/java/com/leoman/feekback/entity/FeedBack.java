package com.leoman.feekback.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.AolUser;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/5/25.
 */
@Entity
@Table(name = "feedback")
public class FeedBack extends BaseEntity{

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "CREATE_USER")
    private AolUser aolUser;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AolUser getAolUser() {
        return aolUser;
    }

    public void setAolUser(AolUser aolUser) {
        this.aolUser = aolUser;
    }
}
