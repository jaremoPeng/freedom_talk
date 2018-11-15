package com.jaremo.freedom_talk.background.dao;

import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.provider.PermissionProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 权限类dao层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 10:57
 */
@Repository
public interface PermissionDao {

    @InsertProvider(type = PermissionProvider.class,method = "addPerm")
    void addPerm(@Param("permission") Permission permission);

    @UpdateProvider(type = PermissionProvider.class,method = "updatePerm")
    void editPerm(@Param("permission") Permission permission);

    @Update("update tb_permission set isDelete=0 where perm_id=#{id}")
    void removePerm(Integer id);

    @Results({
            @Result(property = "id",column = "perm_id",id = true),
            @Result(property = "name",column = "perm_name"),
            @Result(property = "url",column = "perm_url"),
            @Result(property = "sign",column = "perm_sign"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = PermissionProvider.class,method = "findPerm")
    List<Permission> findAllByCondition(@Param("permission") Permission permission);

    @Results({
            @Result(property = "id",column = "perm_id",id = true),
            @Result(property = "name",column = "perm_name"),
            @Result(property = "url",column = "perm_url"),
            @Result(property = "sign",column = "perm_sign"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_permission where perm_id=#{id}")
    Permission findPermById(Integer id);
}
