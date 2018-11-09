package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 聊天类
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 2:37
 */
public class Chat {

    private Integer id; // id
    private String content; // 聊天内容
    private Customer fromCustomer; // 己方id
    private Customer toCustomer; // 对方id
    private String time; // 时间记录
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", fromCustomer=" + fromCustomer +
                ", toCustomer=" + toCustomer +
                ", time='" + time + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) &&
                Objects.equals(content, chat.content) &&
                Objects.equals(fromCustomer, chat.fromCustomer) &&
                Objects.equals(toCustomer, chat.toCustomer) &&
                Objects.equals(time, chat.time) &&
                Objects.equals(isDelete, chat.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, fromCustomer, toCustomer, time, isDelete);
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

    public Customer getFromCustomer() {
        return fromCustomer;
    }

    public void setFromCustomer(Customer fromCustomer) {
        this.fromCustomer = fromCustomer;
    }

    public Customer getToCustomer() {
        return toCustomer;
    }

    public void setToCustomer(Customer toCustomer) {
        this.toCustomer = toCustomer;
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
