package sbarrido.reimbursement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import sbarrido.reimbursement.service.RoleService;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleAssembler roleAssembler;
    
}
