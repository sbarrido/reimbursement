package sbarrido.reimbursement.unit.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.*;

import sbarrido.reimbursement.repository.expense.MileageRepository;
import sbarrido.reimbursement.model.expense.Mileage;
import sbarrido.reimbursement.model.destination.Destination;

import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

@DataJpaTest
public class MileageRepositoryTest {

    @Autowired
    private MileageRepository mRepo;

    private Destination first, second, third;

    @BeforeEach
    private void initialize() {
        first = new Destination("Fort Wayne", 1.0);
        second = new Destination("Indianapolis", 2.0);
        third = new Destination("Bloomington", 3.0);
        List<Mileage> mileages = Arrays.asList(
            new Mileage(new Date(), "first", first),
            new Mileage(new Date(), "second", second),
            new Mileage(new Date(432432L), "third", third)
        );

        mRepo.saveAll(mileages);
    }
    @AfterEach
    private void destroyAll() {
        mRepo.deleteAll();
    }

    @Test
    public void saveMileageTest() {
        Destination test = new Destination("Test", 5.0);
        Mileage testMileage = mRepo.save(new Mileage(new Date(),
                                                    "Description", 
                                                    test));

        Mileage retrieved = mRepo.findById(testMileage.getId()).get();
        Mileage byName = mRepo.findByDestination(test);

        assertThat(testMileage.getDest().getDest()).isEqualTo("Test");
        assertThat(retrieved.getDest().getDest()).isEqualTo("Test");
        assertThat(byName.getDest().getDest()).isEqualTo("Test");

        assertThat(testMileage.getId()).isEqualTo(retrieved.getId());
        assertThat(testMileage.getId()).isEqualTo(byName.getId());
    }

    @Test
    public void findMileageTest() {
        Mileage byName = mRepo.findByDestination(first);

        Date target = new Date();
        LocalDate localDate = target.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        List<Mileage> byDate = mRepo.findByYearAndMonth(year, month);
        Mileage found = byDate.get(1);

        assertThat(byDate.size()).isEqualTo(2);
        assertThat(found.getDest().getDest()).isEqualTo("Indianapolis");
        assertThat(byName.getDest().getDest()).isEqualTo("Fort Wayne");
    }

    @Test
    public void deleteMileageTest() {
        
        Mileage retrieved = mRepo.findByDestination(first);
        assertThat(mRepo.findByDestination(first)).isEqualTo(retrieved);

        mRepo.delete(retrieved);
        assertThat(mRepo.findById(retrieved.getId())).isEmpty();
        assertThat(mRepo.findByDestination(first)).isNull();
        
    }
}

