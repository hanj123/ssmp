package com.Dao;

import com.Domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

//    @Select("select * from users where username = #{userName}")
//    @Results(value = {@Result(id = true, column = "id", property = "id"),
//            @Result(column = "email", property = "email"),
//            @Result(column = "username", property = "username"),
//            @Result(column = "password", property = "password"),
//            @Result(column = "phoneNum", property = "phoneNum"),
//            @Result(column = "status", property = "status"),
//            @Result(column = "id", property = "roles", many = @Many(select = "com.Dao.RoleDao.findRolesByUserId"))})
    UserInfo findByUserName(String userName);

//    @Select("select * from users")
//    @Results(value = {@Result(id = true, column = "id", property = "id"),
//            @Result(column = "email", property = "email"),
//            @Result(column = "username", property = "username"),
//            @Result(column = "password", property = "password"),
//            @Result(column = "phoneNum", property = "phoneNum"),
//            @Result(column = "status", property = "status"),
//            @Result(column = "id", property = "roles", many = @Many(select = "com.Dao.RoleDao.findRolesByUserId"))})
    List<UserInfo> findAll();

//    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);

//    @Select("select * from users where id = #{id}")
//    @Results(value = {@Result(id = true, column = "id", property = "id"),
//            @Result(column = "email", property = "email"),
//            @Result(column = "username", property = "username"),
//            @Result(column = "password", property = "password"),
//            @Result(column = "phoneNum", property = "phoneNum"),
//            @Result(column = "status", property = "status"),
//            @Result(column = "id", property = "roles", many = @Many(select = "com.Dao.RoleDao.findRolesByUserId"))})
    UserInfo findById(Integer id);


//    @Select("select * from users where id in (select userId from users_role where roleId = #{roleId})")
    List<UserInfo> findByRoleId(Integer roleId);

//    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRolesToUser(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    void UpdateNewPwdByName(@Param("newpassword") String newPwd, @Param("username") String username);
}
