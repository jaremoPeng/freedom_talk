package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 留言回复类
 * @Author: pyj
 * @DateTime: 2018/10/31 0031--下午 8:45
 */
public class LeaveWordReply {

    private Integer id; // id
    private LeaveWord leaveWord; // 回复哪条留言
    private Customer fromCustomer; // 留言回复者
    private Customer toCustomer; // 被留言者
    private String replyContent; // 回复留言
    private String replyTime; // 回复时间
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "LeaveWordReply{" +
                "id=" + id +
                ", leaveWord=" + leaveWord +
                ", fromCustomer=" + fromCustomer +
                ", toCustomer=" + toCustomer +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveWordReply that = (LeaveWordReply) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(leaveWord, that.leaveWord) &&
                Objects.equals(fromCustomer, that.fromCustomer) &&
                Objects.equals(toCustomer, that.toCustomer) &&
                Objects.equals(replyContent, that.replyContent) &&
                Objects.equals(replyTime, that.replyTime) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, leaveWord, fromCustomer, toCustomer, replyContent, replyTime, isDelete);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LeaveWord getLeaveWord() {
        return leaveWord;
    }

    public void setLeaveWord(LeaveWord leaveWord) {
        this.leaveWord = leaveWord;
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

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
