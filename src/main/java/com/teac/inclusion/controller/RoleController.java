// src/main/java/com/teac/inclusion/controller/RoleController.java
package com.teac.inclusion.controller;

import com.teac.inclusion.model.Role;
import com.teac.inclusion.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role updated) {
        Role role = roleService.findById(id).orElseThrow();
        role.setName(updated.getName());
        role.setDescription(updated.getDescription());
        return ResponseEntity.ok(roleService.save(role));
    }

    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<Role> toggleRole(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.toggleActive(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


