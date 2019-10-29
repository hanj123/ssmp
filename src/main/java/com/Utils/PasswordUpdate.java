package com.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//密码加密的测试工具类
public class PasswordUpdate {

    public static void passwordUpdate(){
        String password = "456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassword = bCryptPasswordEncoder.encode(password);
        System.out.println(newPassword);
    }

    public static void main(String[] args) {
        passwordUpdate();
    }
}
