package sbarrido.reimbursement.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.repository.user.RoleRepository;

@Service
public class RoleService { 
    private RoleRepository rRepo;

    public RoleService(RoleRepository repo) {
        this.rRepo = repo;
    }

    public ArrayList<Role> getAllRole() {
        ArrayList<Role> target = (ArrayList<Role>) rRepo.findAll();

        return target;
    }
    public Role getRole(Role role) {
        Role target = rRepo.findById(role.getId()).get();
        
        return target;
    }
    public Role getRole(Long id) {
        Role target = rRepo.findById(id).get();
        
        return target;
    }
    public Role createRole(Role role) {
        Role target = null;
        if(!rRepo.existsById(role.getId())) {
            target = rRepo.save(role);
        }

        return target;
    }
    public Role updateRole(Role role) {
        Role target = null;
        if(rRepo.existsById(role.getId())) {
            target = rRepo.findById(role.getId()).get();
            target.setRole(role.getRole());
            
            target = rRepo.save(target);
        }

        return target;
    }
    public void deleteRole(Role role) {
        rRepo.delete(role);
    }
}
