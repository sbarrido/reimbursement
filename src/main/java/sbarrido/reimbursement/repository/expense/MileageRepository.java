package sbarrido.reimbursement.repository.expense;

import org.springframework.data.repository.CrudRepository;
import sbarrido.reimbursement.model.expense.Mileage;
import java.util.List;

public interface MileageRepository extends CrudRepository<Mileage, Long> {

   // List<Mileage> findByYearAndMonth(int year, int month);
}