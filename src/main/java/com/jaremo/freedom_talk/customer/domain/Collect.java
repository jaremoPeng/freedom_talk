package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 收藏类
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:02
 */
public class Collect {

    private Integer id; // id
    private Customer customer; // 哪个客户
    private Note note; // 哪篇帖子
    private String time; // 收藏的时间
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", customer=" + customer +
                ", note=" + note +
                ", time='" + time + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collect collect = (Collect) o;
        return Objects.equals(id, collect.id) &&
                Objects.equals(customer, collect.customer) &&
                Objects.equals(note, collect.note) &&
                Objects.equals(time, collect.time) &&
                Objects.equals(isDelete, collect.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, note, time, isDelete);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
