package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbarrido.reimbursement.repository.user.UserRepository;
import sbarrido.reimbursement.model.user.User;

import java.util.Set;
import java.util.HashSet;

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
    public User getUser(User user) {
        User target = uRepository.findById(user.getId()).get();

        return target;
    }
    public User getUser(String username) {
        User target = uRepository.findByUsername(username);

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