package sbarrido.reimbursement.repository.expense;

import org.springframework.data.repository.CrudRepository;
import sbarrido.reimbursement.model.expense.OtherExp;
import java.util.List;

public interface OtherExpRepository extends CrudRepository<OtherExp, Long> {

    List<OtherExp> findByYearAndMonth(int year, int month);
}