package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 禁止留言
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 1:03
 */
public class UnLeaveWord {

    private Integer id;
    private Customer fromCustomer;
    private Customer toCustomer;
    private Integer isDelete;

    @Override
    public String toString() {
        return "UnLeaveWord{" +
                "id=" + id +
                ", fromCustomer=" + fromCustomer +
                ", toCustomer=" + toCustomer +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnLeaveWord that = (UnLeaveWord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fromCustomer, that.fromCustomer) &&
                Objects.equals(toCustomer, that.toCustomer) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fromCustomer, toCustomer, isDelete);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
