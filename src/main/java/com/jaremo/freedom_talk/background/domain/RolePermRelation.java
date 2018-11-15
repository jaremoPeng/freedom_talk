package com.jaremo.freedom_talk.background.domain;

/**
 * @描述: 角色和权限的关系类
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 10:26
 */
public class RolePermRelation {

    private Integer rid;
    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
