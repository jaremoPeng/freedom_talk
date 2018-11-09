package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 好友
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 12:50
 */
public class HailFellow {

    private Integer id; // id
    private Customer fromCustomer; // 客户
    private Customer toCustomer; // 对方客户id
    private String remarks; // 备注
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "HailFellow{" +
                "id=" + id +
                ", fromCustomer=" + fromCustomer +
                ", toCustomer=" + toCustomer +
                ", remarks='" + remarks + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HailFellow that = (HailFellow) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fromCustomer, that.fromCustomer) &&
                Objects.equals(toCustomer, that.toCustomer) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fromCustomer, toCustomer, remarks, isDelete);
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
