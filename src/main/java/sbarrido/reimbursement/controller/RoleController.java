package sbarrido.reimbursement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbarrido.reimbursement.dto.model.RoleDto;
import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.service.RoleService;
import sbarrido.reimbursement.util.assembler.RoleAssembler;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleAssembler roleAssembler;
    
    @GetMapping(value = "/roles/{id}", produces = "application/json")
    public RoleDto getRoleById(@PathVariable Long id) {
        Role role = roleService.getRole(id);

        return roleAssembler.toModel(role);
    }
    @GetMapping(value = "/roles", produces = "application/json") 
    public CollectionModel<RoleDto> getAllRole() {
        ArrayList<Role> roleList = roleService.getAllRole();

        return roleAssembler.toCollectionModel(roleList);
    }
    @PostMapping(path = "/roles", consumes = "application/json")
    public Role create(@RequestBody RoleDto roleDTO) {
        Role target = roleAssembler.toEntity(roleDTO);
        roleService.createRole(target);

        return target;
    }
    @DeleteMapping(value = "/roles/{id}")
    public Role delete(@PathVariable Long id) {
        Role target = roleService.getRole(id);
        roleService.deleteRole(target);

        return target;
    }
}
