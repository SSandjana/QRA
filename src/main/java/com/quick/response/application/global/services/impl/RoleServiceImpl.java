package com.quick.response.application.global.services.impl;

import com.quick.response.application.global.entities.Role;
import com.quick.response.application.global.repositories.RoleRepository;
import com.quick.response.application.global.services.RoleService;
import com.quick.response.application.global.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public final class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getClientRoleId() {
        return roleRepository.getById(Constants.CLIENT_ROLE_ID);
    }

    @Override
    public Role getPoliceRoleId() {
        return roleRepository.getById(Constants.POLICE_ROLE_ID);
    }

    @Override
    public Role getAdminRoleId() {
        return roleRepository.getById(Constants.ADMIN_ROLE_ID);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }
}
