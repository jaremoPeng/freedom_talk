package com.jaremo.freedom_talk.customer.domain;

import com.jaremo.freedom_talk.background.domain.Category;

import java.util.Objects;

/**
 * @描述: 帖子类
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:16
 */
public class Note {

    private Integer id; // 帖子的id
    private String title; // 标题
    private String content; // 内容
    private Customer customer; // 发布者
    private Integer browserNum; // 浏览数
    private Integer commentNum; // 评论数
    private String img; // 图片
    private Category category; // 分类
    private String time; // 发表时间
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", customer=" + customer +
                ", browserNum=" + browserNum +
                ", commentNum=" + commentNum +
                ", img='" + img + '\'' +
                ", category=" + category +
                ", time='" + time + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getBrowserNum() {
        return browserNum;
    }

    public void setBrowserNum(Integer browserNum) {
        this.browserNum = browserNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) &&
                Objects.equals(title, note.title) &&
                Objects.equals(content, note.content) &&
                Objects.equals(customer, note.customer) &&
                Objects.equals(browserNum, note.browserNum) &&
                Objects.equals(commentNum, note.commentNum) &&
                Objects.equals(img, note.img) &&
                Objects.equals(category, note.category) &&
                Objects.equals(time, note.time) &&
                Objects.equals(isDelete, note.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, content, customer, browserNum, commentNum, img, category, time, isDelete);
    }
}
