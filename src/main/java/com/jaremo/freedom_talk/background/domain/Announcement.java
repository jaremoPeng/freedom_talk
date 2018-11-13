package com.jaremo.freedom_talk.background.domain;

import java.util.Objects;

/**
 * @描述: 公告类
 * @Author: pyj
 * @DateTime: 2018/11/13 0013--上午 9:38
 */
public class Announcement {

    private Integer id; // id
    private String content; // 公告内容
    private String time; // 公告发布的时间
    private Integer isDelete; // 是否删除

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(time, that.time) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, time, isDelete);
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
