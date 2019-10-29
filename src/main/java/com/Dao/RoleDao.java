package com.Dao;

import com.Domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

//    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    List<Role> findRolesByUserId(String userId);

//    @Select("select * from role where id in (select roleId from role_permission where permissionId=#{permissionId})")
    List<Role> findByPermissionId(Integer permissionId);


//    @Select("select * from role")
//    @Results({
//            @Result(id = true,column = "id",property = "id"),
//            @Result(column = "roleName",property = "roleName"),
//            @Result(column = "roleDesc",property = "roleDesc"),
//            @Result(column = "id",property = "permissions",many = @Many(select = "com.Dao.PermissionDao.findByRoleId")),
//            @Result(column = "id",property = "userInfos",many = @Many(select = "com.Dao.UserDao.findByRoleId"))})
    List<Role> findAll();

//    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    void addRole(Role role);

//    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(Integer userId);
}
