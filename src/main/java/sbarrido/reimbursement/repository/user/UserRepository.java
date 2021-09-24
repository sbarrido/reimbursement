package sbarrido.reimbursement.repository.user;

import org.springframework.data.repository.CrudRepository;
import sbarrido.reimbursement.model.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByUsername(String username);
}