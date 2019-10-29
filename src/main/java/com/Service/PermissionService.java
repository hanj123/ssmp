package com.Service;

import com.Domain.Permission;

import java.util.List;

public interface PermissionService {


    List<Permission> findAll();

    void savePermission(Permission permission);
}
