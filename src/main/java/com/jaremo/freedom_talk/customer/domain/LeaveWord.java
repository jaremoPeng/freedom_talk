package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 留言
 * @Author: pyj
 * @DateTime: 2018/10/31 0031--下午 8:13
 */
public class LeaveWord {

    private Integer id; // 留言ID
    private String content; // 留言内容
    private Customer fromCustomer; // 留言者
    private Customer toCustomer; // 被留言者
    private String time; // 留言时间
    private Integer isStart; // 是否开启留言板(指留言者是否开启留言板)
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "LeaveWord{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", fromCustomer=" + fromCustomer +
                ", toCustomer=" + toCustomer +
                ", time='" + time + '\'' +
                ", isStart=" + isStart +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveWord leaveWord = (LeaveWord) o;
        return Objects.equals(id, leaveWord.id) &&
                Objects.equals(content, leaveWord.content) &&
                Objects.equals(fromCustomer, leaveWord.fromCustomer) &&
                Objects.equals(toCustomer, leaveWord.toCustomer) &&
                Objects.equals(time, leaveWord.time) &&
                Objects.equals(isStart, leaveWord.isStart) &&
                Objects.equals(isDelete, leaveWord.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, fromCustomer, toCustomer, time, isStart, isDelete);
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

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
