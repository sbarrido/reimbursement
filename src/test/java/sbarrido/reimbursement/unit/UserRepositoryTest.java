package sbarrido.reimbursement.unit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;

import sbarrido.reimbursement.repository.user.UserRepository;
import sbarrido.reimbursement.model.user.User;

@DataJpaTest
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;


    @Test
    public void saveUserTest() {
        assertThat(userRepo.findById(1L)).isEmpty();

        User testUser = userRepo.save(new User("Test", "pass"));

        User retrieved = userRepo.findById(testUser.getId()).get();
        User byName = userRepo.findByUsername("Test");

        assertThat(testUser.getUsername()).isEqualTo("Test");
        assertThat(retrieved.getUsername()).isEqualTo("Test");
        assertThat(byName.getUsername()).isEqualTo("Test");

        assertThat(testUser.getId()).isEqualTo(retrieved.getId());
        assertThat(testUser.getId()).isEqualTo(byName.getId());
    }

    @Test
    public void findUserTest() {
        User byId = userRepo.findById(1L).get();
        User byName = userRepo.findByUsername("Test");

        assertThat(byId.getUsername()).isEqualTo("Test");
        assertThat(byName.getUsername()).isEqualTo("Test");
        assertThat(byId.getId()).isEqualTo(1L);
        assertThat(byName.getId()).isEqualTo(1L);
    }

    @Test
    public void deleteUserTest() {
        User retrieved = userRepo.findById(1L).get();
        assertThat(userRepo.findById(1L)).isNotEmpty();
        assertThat(userRepo.findByUsername("Test")).isEqualTo(retrieved);

        userRepo.delete(retrieved);
        assertThat(userRepo.findById(1L)).isEmpty();
        assertThat(userRepo.findByUsername("Test")).isNull();
    }
}