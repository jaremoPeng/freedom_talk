package com.jaremo.freedom_talk.background.dao;

import com.jaremo.freedom_talk.background.domain.Role;
import com.jaremo.freedom_talk.background.provider.RoleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 角色类dao层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 10:01
 */
@Repository
public interface RoleDao {

    @Insert("insert into tb_role(role_name) values(#{role.name})")
    void addRole(@Param("role") Role role);

    @Update("update tb_role set isDelete=0 where role_id=#{id}")
    void removeRole(Integer id);

    @Update("update tb_role set role_name=#{role.name} where role_id=#{id}")
    void editRole(@Param("role") Role role);

    @Results({
            @Result(property = "id",column = "role_id",id = true),
            @Result(property = "name",column = "role_name"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = RoleProvider.class,method = "findRole")
    List<Role> findRoleByCondition(@Param("role") Role role);
}
