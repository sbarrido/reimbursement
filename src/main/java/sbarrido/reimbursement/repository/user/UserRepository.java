package sbarrido.reimbursement.repository.user;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.model.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByUsername(String username);
    ArrayList<User> findByRoles(Role role);
}