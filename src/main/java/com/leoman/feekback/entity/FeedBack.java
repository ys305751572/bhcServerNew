package com.leoman.feekback.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.AolUser;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "feekback_id")
    private List<FeedbackImage> list;

    public List<FeedbackImage> getList() {
        return list;
    }

    public void setList(List<FeedbackImage> list) {
        this.list = list;
    }

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
