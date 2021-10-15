package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;

import sbarrido.reimbursement.repository.user.UserRepository;
import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.model.user.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private UserRepository uRepository;

    public UserService(UserRepository repo) {
        this.uRepository = repo;
    }

    public Set<User> getAllUser() {
        Set<User> target = (HashSet<User>) uRepository.findAll();

        return target;
    }
    // public Set<User> getAllUserByRole(Role role) {
    //     Set<User> target = uRepository.findByRole(role);

    //     return target;
    // }
    public User getUser(User user) {
        User target = uRepository.findById(user.getId()).get();

        return target;
    }
    public User getUser(String username) {
        User target = uRepository.findByUsername(username);

        return target;
    }
    public User getUser(Long id) {
        User target = uRepository.findById(id).get();

        return target;
    }
    public User createUser(User user) {
        User target = null;
        if(!uRepository.existsById(user.getId())) {
            target = uRepository.save(user);
        }

        return target;
    }
    public User updateUser(User user) {
        User target = null;
        if(uRepository.existsById(user.getId())) {
            target = uRepository.findById(user.getId()).get();
            target.setUsername(user.getUsername());
            target.setPassword(user.getPassword());
            target.setRoles(user.getRoles());

            target = uRepository.save(target);
        }

        return target;
    }
    public void deleteUser(User user) {
        uRepository.delete(user);
    }
}