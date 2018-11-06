package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 观点类回复类
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 1:02
 */
public class ViewPointReply {

    private Integer id; // id
    private String content; // 观点回复内容
    private ViewPoint viewPoint; // 哪条观点
    private Customer fromCustomer; // 回复者
    private Customer toCustomer; // 接收者
    private String time; // 回复时间
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "ViewPointReply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", viewPoint=" + viewPoint +
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
        ViewPointReply that = (ViewPointReply) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(viewPoint, that.viewPoint) &&
                Objects.equals(fromCustomer, that.fromCustomer) &&
                Objects.equals(toCustomer, that.toCustomer) &&
                Objects.equals(time, that.time) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, viewPoint, fromCustomer, toCustomer, time, isDelete);
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

    public ViewPoint getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(ViewPoint viewPoint) {
        this.viewPoint = viewPoint;
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
