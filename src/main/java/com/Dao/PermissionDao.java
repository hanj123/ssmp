package com.Dao;

import com.Domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PermissionDao {

//    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(Integer roleId);

//    @Select("select * from permission")
//    @Results({@Result(id = true,column = "id",property = "id"),
//    @Result(column = "permissionName",property = "permissionName"),
//    @Result(column = "url",property = "url"),
//    @Result(column = "id",property = "roles",many = @Many(select = "com.Dao.RoleDao.findByPermissionId"))})
    List<Permission> findAll();

//    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void savePermission(Permission permission);
}
