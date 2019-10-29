package com.Service;

import com.Domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void addRole(Role role);

    List<Role> findOtherRoles(Integer userId);
}
