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

import sbarrido.reimbursement.repository.expense.OtherExpRepository;
import sbarrido.reimbursement.model.expense.OtherExp;

import java.util.List;
import java.util.Arrays;
import java.util.Date;

@DataJpaTest
public class OtherExpRepositoryTest {

    @Autowired
    private OtherExpRepository oRepo;

    @BeforeEach
    private void initialize() {
        List<OtherExp> expenses = Arrays.asList(
            new OtherExp(new Date(),
                         "first",
                         "Vendor1",
                         "Path1",
                         1.0),
            new OtherExp(new Date(),
                         "second",
                         "Vendor2",
                         "Path2",
                         2.0),
            new OtherExp(new Date(243243242L),
                         "third",
                         "Vendor3",
                         "Path3",
                         3.0)
        );

        oRepo.saveAll(expenses);
    }
    @AfterEach
    private void destroyAll() {
        oRepo.deleteAll();
    }

    @Test
    public void saveOtherExpTest() {   
        OtherExp testOther = new OtherExp(new Date(),"Test","vendorTest", "testPath", 5.0);
        testOther = oRepo.save(testOther);

        OtherExp retrieved = oRepo.findById(testOther.getId()).get();
        OtherExp byVendor = oRepo.findByVendor(testOther.getVendor());

        assertThat(testOther.getId()).isEqualTo(retrieved.getId());
        assertThat(testOther.getId()).isEqualTo(byVendor.getId());

        assertThat(testOther.getVendor()).isEqualTo(retrieved.getVendor());
        assertThat(testOther.getVendor()).isEqualTo(byVendor.getVendor());
    }

    @Test
    public void findOtherExpTest() {
        OtherExp byName = oRepo.findByVendor("Vendor2");

        
        assertThat(byName.getVendor()).isEqualTo("Vendor2");
        assertThat(byName.getImgPath()).isEqualTo("Path2");
    }

    @Test
    public void deleteMileageTest() {
        
        OtherExp retrieved = oRepo.findByVendor("Vendor2");
        assertThat(oRepo.findByVendor("Vendor2")).isEqualTo(retrieved);

        oRepo.delete(retrieved);
        assertThat(oRepo.findById(retrieved.getId())).isEmpty();
        assertThat(oRepo.findByVendor("Vendor2")).isNull();
        
    }
}

