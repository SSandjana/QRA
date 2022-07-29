package com.quick.response.application.global.services;

import com.quick.response.application.global.entities.Role;

import java.util.List;

public interface RoleService {
    Role getClientRoleId();

    Role getPoliceRoleId();

    Role getAdminRoleId();

    List<Role> findAllRoles();

    Role getRoleById(Long id);
}
