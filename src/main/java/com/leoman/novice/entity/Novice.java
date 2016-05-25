package com.leoman.novice.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/5/25.
 */
@Entity
@Table(name = "novice")
public class Novice extends BaseEntity{

    @Column(name = "content")
    private String content;

    @Column(name = "path")
    private String path;

    @Column(name = "index2")
    private Integer index2;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getIndex2() {
        return index2;
    }

    public void setIndex2(Integer index2) {
        this.index2 = index2;
    }
}
