package sbarrido.reimburseemnt.unit;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import src.main.java.sbarrido.reimbursement.service.UserService;
import src.main.java.sbarrido.reimbursement.repository.UserRepository;
import src.main.java.sbarrido.reimbursement.model.user.User;

@SpringBootTest
public class ServiceUnitTest {

    @MockBean
    private UserRepository uRepo;

    @Autowired
    private UserService uService;

    @Test
    public void createUserTest() {
        User testUser = new User("TestName", "TestPass");
        when(uRepo.save(any(User.class))).thenReturn(new User());

        User created = userService.save(testUser);
        
        assertThat(created.getId()).isSameAs(testUser.getId());
    }
}