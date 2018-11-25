package com.jaremo.freedom_talk.customer.domain;

import java.util.List;
import java.util.Objects;

/**
 * @描述: 观点类
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--上午 9:15
 */
public class ViewPoint {

    private Integer id; // 观点id
    private String content; // 观点内容
    private Customer customer; // 发表者
    private Note note; // 哪篇帖子
    private String time; // 发表时间
    private Integer isDelete; // 是否删除
    private List<ViewPointReply> viewPointReplyList; // 该评论的所有回复

    @Override
    public String toString() {
        return "ViewPoint{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", customer=" + customer +
                ", note=" + note +
                ", time='" + time + '\'' +
                ", isDelete=" + isDelete +
                ", viewPointReplyList=" + viewPointReplyList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewPoint viewPoint = (ViewPoint) o;
        return Objects.equals(id, viewPoint.id) &&
                Objects.equals(content, viewPoint.content) &&
                Objects.equals(customer, viewPoint.customer) &&
                Objects.equals(note, viewPoint.note) &&
                Objects.equals(time, viewPoint.time) &&
                Objects.equals(isDelete, viewPoint.isDelete) &&
                Objects.equals(viewPointReplyList, viewPoint.viewPointReplyList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, customer, note, time, isDelete, viewPointReplyList);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
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

    public List<ViewPointReply> getViewPointReplyList() {
        return viewPointReplyList;
    }

    public void setViewPointReplyList(List<ViewPointReply> viewPointReplyList) {
        this.viewPointReplyList = viewPointReplyList;
    }
}
