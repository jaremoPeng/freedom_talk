package com.jaremo.freedom_talk.background.domain;

import java.util.List;
import java.util.Objects;

/**
 * @描述: 角色类
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 9:53
 */
public class Role {

    private Integer id;
    private String name;
    private Integer isDelete;
    private List<Permission> permList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDelete=" + isDelete +
                ", permList=" + permList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(isDelete, role.isDelete) &&
                Objects.equals(permList, role.permList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, isDelete, permList);
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<Permission> getPermList() {
        return permList;
    }

    public void setPermList(List<Permission> permList) {
        this.permList = permList;
    }
}
