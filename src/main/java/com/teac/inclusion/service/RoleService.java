// src/main/java/com/teac/inclusion/service/RoleService.java
package com.teac.inclusion.service;

import com.teac.inclusion.model.Role;
import com.teac.inclusion.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role toggleActive(Long id) {
        Role role = roleRepository.findById(id).orElseThrow();
        role.setActive(!role.getActive());
        return roleRepository.save(role);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}


