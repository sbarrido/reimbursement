package sbarrido.reimbursement.unit.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;

import sbarrido.reimbursement.repository.user.UserRepository;
import sbarrido.reimbursement.model.user.User;

import java.util.List;
import java.util.Arrays;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;


    @BeforeEach
    private void initialize() {
        List<User> users = Arrays.asList(
            new User("DefaultTest1", "pass1"),
            new User("DefaultTest2", "Pass2")
        );

        userRepo.saveAll(users);
    }
    @AfterEach
    private void destroyAll() {
        userRepo.deleteAll();
    }
    
    @Test
    public void saveUserTest() {
        assertThat(userRepo.findByUsername("saveTest")).isNull();

        User testUser = userRepo.save(new User("saveTest", "passSave"));

        User retrieved = userRepo.findById(testUser.getId()).get();
        User byName = userRepo.findByUsername("saveTest");

        assertThat(testUser.getUsername()).isEqualTo("saveTest");
        assertThat(retrieved.getUsername()).isEqualTo("saveTest");
        assertThat(byName.getUsername()).isEqualTo("saveTest");

        assertThat(testUser.getId()).isEqualTo(retrieved.getId());
        assertThat(testUser.getId()).isEqualTo(byName.getId());

        assertThat(userRepo.findById(testUser.getId()).get().getUsername()).isEqualTo("saveTest");
    }

    
    @Test
    public void findUserTest() {
        User byName = userRepo.findByUsername("DefaultTest1");
        User byId = userRepo.findById(byName.getId()).get();

        assertThat(byName.getUsername()).isEqualTo("DefaultTest1");
        assertThat(byId.getUsername()).isEqualTo("DefaultTest1");
    }

    
    @Test
    public void deleteUserTest() {
        User retrieved = userRepo.findByUsername("DefaultTest2");
        assertThat(userRepo.findByUsername("DefaultTest2")).isEqualTo(retrieved);

        userRepo.delete(retrieved);
        assertThat(userRepo.findById(retrieved.getId())).isEmpty();
        assertThat(userRepo.findByUsername("DefaultTest2")).isNull();
    }
    
}
