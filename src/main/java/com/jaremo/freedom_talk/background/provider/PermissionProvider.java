package com.jaremo.freedom_talk.background.provider;

import com.jaremo.freedom_talk.background.domain.Permission;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 权限类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 3:52
 */
public class PermissionProvider {

    public String addPerm(Map map){
        Permission permission = (Permission) map.get("permission");
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_permission");
        if(permission.getName()!=null){
            sql.VALUES("perm_name","#{permission.name}");
        }
        if(permission.getUrl()!=null){
            sql.VALUES("perm_url","#{permission.url}");
        }
        if(permission.getSign()!=null){
            sql.VALUES("perm_sign","#{permission.sign}");
        }
        return sql.toString();
    }

    public String updatePerm(Map map){
        Permission permission = (Permission) map.get("permission");
        SQL sql = new SQL();
        sql.UPDATE("tb_permission");
        if(permission.getName()!=null){
            sql.SET("perm_name=#{permission.name}");
        }
        if(permission.getUrl()!=null){
            sql.SET("perm_url=#{permission.url}");
        }
        if(permission.getSign()!=null){
            sql.SET("perm_sign=#{permission.sign}");
        }
        if(permission.getId()!=null){
            sql.WHERE("perm_id=#{permission.id}");
        }
        return sql.toString();
    }

    public String findPerm(Map map){
        Permission permission = (Permission) map.get("permission");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_permission");
        if(permission.getName()!=null){
            sql.WHERE("perm_name=#{permission.name}");
        }
        if(permission.getSign()!=null){
            sql.WHERE("perm_sign=#{permission.sign}");
        }
        if(permission.getId()!=null){
            sql.WHERE("perm_id=#{permission.id}");
        }
        if(permission.getIsDelete()!=null){
            sql.WHERE("isDelete=#{permission.isDelete}");
        }
        return sql.toString();
    }
}
