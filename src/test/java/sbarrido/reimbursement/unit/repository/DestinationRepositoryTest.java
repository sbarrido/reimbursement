package sbarrido.reimbursement.unit.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.*;

import sbarrido.reimbursement.repository.destination.DestinationRepository;
import sbarrido.reimbursement.model.destination.Destination;

import java.util.List;
import java.util.Arrays;

@DataJpaTest
public class DestinationRepositoryTest {

    @Autowired
    private DestinationRepository dRepo;

    @BeforeEach
    private void initialize() {
        List<Destination> dests = Arrays.asList(
            new Destination("DefaultTest1", 1.0),
            new Destination("DefaultTest2", 2.0)
        );

        dRepo.saveAll(dests);
    }
    @AfterEach
    private void destroyAll() {
        dRepo.deleteAll();
    }

    @Test
    public void saveDestTest() {
        assertThat(dRepo.findByLocation("Test")).isNull();

        Destination testDest = dRepo.save(new Destination("Test", 2.0));

        Destination retrieved = dRepo.findById(testDest.getId()).get();
        Destination byName = dRepo.findByLocation("Test");

        assertThat(testDest.getDest()).isEqualTo("Test");
        assertThat(retrieved.getDest()).isEqualTo("Test");
        assertThat(byName.getDest()).isEqualTo("Test");

        assertThat(testDest.getId()).isEqualTo(retrieved.getId());
        assertThat(testDest.getId()).isEqualTo(byName.getId());

        assertThat(testDest.getDist()).isEqualTo(2.0);
        assertThat(retrieved.getDist()).isEqualTo(2.0);
        assertThat(byName.getDist()).isEqualTo(2.0);
    }

    @Test
    public void findDestTest() {
        Destination byName = dRepo.findByLocation("DefaultTest1");

        
        assertThat(byName.getDest()).isEqualTo("DefaultTest1");
        assertThat(byName.getId()).isEqualTo(byName.getId());
        assertThat(byName.getDist()).isEqualTo(1.0);
    }

    @Test
    public void deleteDestTest() {
        
        Destination retrieved = dRepo.findByLocation("DefaultTest1");
        assertThat(dRepo.findByLocation("DefaultTest1")).isEqualTo(retrieved);

        dRepo.delete(retrieved);
        assertThat(dRepo.findById(retrieved.getId())).isEmpty();
        assertThat(dRepo.findByLocation("DefaultTest1")).isNull();
        
    }
}

