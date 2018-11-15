package com.jaremo.freedom_talk.background.domain;

import java.util.Objects;

/**
 * @描述: 权限类
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 9:57
 */
public class Permission {

    private Integer id; // id
    private String name; // 权限名称
    private String url; // 资源地址
    private String sign; // 标识
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sign='" + sign + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(sign, that.sign) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, url, sign, isDelete);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
