package com.jaremo.freedom_talk.background.domain;

import java.util.Objects;

/**
 * @描述: 登录问题类
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 6:51
 */
public class Question {

    private Integer id; // id
    private String questionContent; // 问题内容

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionContent='" + questionContent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(questionContent, question.questionContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, questionContent);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
