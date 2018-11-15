package com.jaremo.freedom_talk.background.provider;

import com.jaremo.freedom_talk.background.domain.Role;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 角色类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 10:47
 */
public class RoleProvider {

    public String findRole(Map map){
        Role role = (Role) map.get("role");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_role");
        if(role.getId()!=null){
            sql.WHERE("role_id=#{role.id}");
        }
        if(role.getIsDelete()!=null){
            sql.WHERE("isDelete=#{role.isDelete}");
        }
        return sql.toString();
    }
}
