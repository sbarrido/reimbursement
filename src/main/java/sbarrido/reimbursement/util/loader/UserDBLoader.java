package sbarrido.reimbursement.util.loader;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.model.user.User;
import sbarrido.reimbursement.model.user.UserRoles;
import sbarrido.reimbursement.repository.user.RoleRepository;
import sbarrido.reimbursement.repository.user.UserRepository;

@Component
public class UserDBLoader implements CommandLineRunner {
    private final RoleRepository rRepository;
    private final UserRepository uRepository;

    @Autowired
    public UserDBLoader(RoleRepository roles, UserRepository users) {
        this.rRepository = roles;
        this.uRepository = users;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        initializeRoles();
        initializeUsers();
    }

    private void initializeRoles() {
        Role admin = new Role();
        Role user = new Role();

        admin.setRole(UserRoles.ADMIN);
        user.setRole(UserRoles.USER);

        this.rRepository.save(admin);
        this.rRepository.save(user);
    }
    private void initializeUsers() {
        User testAdmin = new User("testAdmin", "adminPass");
        User testUser = new User("testUser", "userPass");

        testAdmin.setRoles(Arrays.asList(
            this.rRepository.findById(1L).get(), 
            this.rRepository.findById(2L).get()
        ));
        testUser.setRoles(Arrays.asList(
            this.rRepository.findById(2L).get()
        ));
        this.uRepository.save(testAdmin);
        this.uRepository.save(testUser);
    }
}