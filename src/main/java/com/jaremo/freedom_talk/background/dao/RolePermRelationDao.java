package com.jaremo.freedom_talk.background.dao;

import com.jaremo.freedom_talk.background.domain.RolePermRelation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 角色和权限表的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 10:13
 */
@Repository
public interface RolePermRelationDao {

    @Results({
            @Result(property = "rid",column = "role_id"),
            @Result(property = "pid",column = "perm_id")
    })
    @Select("select * from role_permission_relation")
    List<RolePermRelation> findPidByRid(Integer rid);

    @Insert("insert into role_permission_relation (role_id,perm_id) values (#{rid},#{pid})")
    void addRolePermRelation(@Param("rid") Integer rid,@Param("pid") Integer pid);

    @Delete("delete from role_permission_relation where role_id=#{rid}")
    void removeRole(Integer rid);
}
