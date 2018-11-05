package com.jaremo.freedom_talk.background.domain;

import java.util.Objects;

/**
 * @描述: 分类
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 3:16
 */
public class Category {

    private Integer id; // id
    private String name; // 分类名
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(isDelete, category.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, isDelete);
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
}
