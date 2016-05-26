package com.leoman.feekback.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.AolUser;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
@Entity
@Table(name = "feedback")
public class FeedBack{

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id = null;

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

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "modify_date")
    private Long modifyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

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
