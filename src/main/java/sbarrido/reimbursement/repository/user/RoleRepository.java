package sbarrido.reimbursement.repository.user;

import org.springframework.data.repository.CrudRepository;
import sbarrido.reimbursement.model.user.Role;


public interface RoleRepository extends CrudRepository<Role, String> {
    
    Role findByRole(String role);
}