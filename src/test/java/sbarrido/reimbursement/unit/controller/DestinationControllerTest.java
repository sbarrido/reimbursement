package sbarrido.reimbursement.unit.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import sbarrido.reimbursement.repository.destination.DestinationRepository;
import sbarrido.reimbursement.controller.DestinationController;
import sbarrido.reimbursement.model.destination.Destination;


@SpringBootTest
@AutoConfigureMockMvc
public class DestinationControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DestinationRepository dRepo;

    private static HashSet<Destination> set;

    @BeforeAll
    private static void setup() {
        set = new HashSet<>();
        set.add(new Destination("Fort_Wayne",14.2));
        set.add(new Destination("Chicago",43.6));
    }
    @Test
    public void getHal() throws Exception{
        dRepo.saveAll(set);
        given(dRepo.findByLocation("Chicago")).willReturn(new Destination("Chicago", 43.6));
        mockMvc.perform(get("/destinations/Chicago").accept(MediaTypes.HAL_JSON_VALUE))
                    .andDo(print());
    }
}