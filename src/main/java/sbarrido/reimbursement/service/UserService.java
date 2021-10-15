package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;

import sbarrido.reimbursement.repository.user.UserRepository;
import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.model.user.User;

import java.util.ArrayList;

@Service
public class UserService {
    private UserRepository uRepository;

    public UserService(UserRepository repo) {
        this.uRepository = repo;
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> target = (ArrayList<User>) uRepository.findAll();

        return target;
    }
    public ArrayList<User> getAllUserByRoles(Role role) {
        ArrayList<User> target = uRepository.findByRoles(role);

        return target;
    }
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