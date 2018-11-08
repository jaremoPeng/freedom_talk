package com.jaremo.freedom_talk.customer.domain;

import java.util.Objects;

/**
 * @描述: 我的关注
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 2:14
 */
public class Follow {

    private Integer id; // id
    private Customer customer; // 客户
    private Customer moderator; // 版主

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", customer=" + customer +
                ", moderator=" + moderator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(id, follow.id) &&
                Objects.equals(customer, follow.customer) &&
                Objects.equals(moderator, follow.moderator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customer, moderator);
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

    public Customer getModerator() {
        return moderator;
    }

    public void setModerator(Customer moderator) {
        this.moderator = moderator;
    }
}
