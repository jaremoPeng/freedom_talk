package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 消息类
 * @Author: pyj
 * @DateTime: 2018/11/10 0010--下午 12:57
 */
public class Message {

    private Integer id; // id
    private Customer customer; // 客户
    private String content; // 消息体
    private Integer isDelete; // 是否删除
    private Integer isRead; // 是否已读

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", customer=" + customer +
                ", content='" + content + '\'' +
                ", isDelete=" + isDelete +
                ", isRead=" + isRead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(customer, message.customer) &&
                Objects.equals(content, message.content) &&
                Objects.equals(isDelete, message.isDelete) &&
                Objects.equals(isRead, message.isRead);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, content, isDelete, isRead);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}
