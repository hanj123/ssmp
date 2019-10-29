package com.Service;

import com.Domain.Role;
import com.Domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    public void addUser(UserInfo userInfo);

    public List<UserInfo> findAll();

    UserInfo findById(Integer id);

    void addRolesToUser(Integer userId, Integer roleId);

    String encodePwd(String pwd);

    void UpdateNewPwdByName(String newPwd, String username);

    boolean matchPwd(String inputPwd,String encodePwd);

    boolean checkInfo(String username,String password);
}
