package com.quick.response.application.global.controller;

import com.quick.response.application.global.entities.Role;
import com.quick.response.application.global.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllSubscriptions() {
        List<Role> allRoles = roleService.findAllRoles();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

}
