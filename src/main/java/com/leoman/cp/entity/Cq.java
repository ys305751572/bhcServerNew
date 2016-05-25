package com.leoman.cp.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 常见问题
 * Created by Administrator on 2016/5/25.
 */
@Entity
@Table(name = "question")
public class Cq extends BaseEntity{

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
