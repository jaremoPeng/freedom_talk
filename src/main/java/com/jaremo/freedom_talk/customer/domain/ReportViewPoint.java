package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 禁止发表观点
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 12:57
 */
public class ReportViewPoint {

    private Integer id; // id
    private Note note; // 该贴子必须是指定版主所发的
    private Customer fromCustomer; // 指定版主
    private Customer toCustomer; // 被禁用户
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "ReportViewPoint{" +
                "id=" + id +
                ", note=" + note +
                ", fromCustomer=" + fromCustomer +
                ", toCustomer=" + toCustomer +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportViewPoint that = (ReportViewPoint) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(note, that.note) &&
                Objects.equals(fromCustomer, that.fromCustomer) &&
                Objects.equals(toCustomer, that.toCustomer) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, note, fromCustomer, toCustomer, isDelete);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
