package com.Service.impl;

import com.Dao.RoleDao;
import com.Dao.UserDao;
import com.Domain.Role;
import com.Domain.UserInfo;
import com.Service.UserService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUserName(username);
        List<Role> roles = userInfo.getRoles();
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),getAuthorities(roles));

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role role:roles){
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return list;
    }

    public void addUser(UserInfo userInfo){

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.addUser(userInfo);
    }

//    加密密码
    public String encodePwd(String pwd){
        return passwordEncoder.encode(pwd);
    }

    //匹配输入的密码和数据库中加密的密码是否是同一个密码
    public boolean matchPwd(String inputPwd,String encodePwd){
        return passwordEncoder.matches(inputPwd,encodePwd);
    }


    public List<UserInfo> findAll(){
        return userDao.findAll();
    }

    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void addRolesToUser(Integer userId,Integer roleId) {
        userDao.addRolesToUser(userId,roleId);
    }

    @Override
    public void UpdateNewPwdByName(String newPwd, String username) {
            userDao.UpdateNewPwdByName(newPwd,username);
    }

    @Override
    public boolean checkInfo(String username, String password) {
        UserInfo user = userDao.findByUserName(username);
        if(user==null){
            return false;
        }else {
            String encodePwd = user.getPassword();
            if(matchPwd(password,encodePwd)){
                return true;
            }
        }
        return false;
    }
}
