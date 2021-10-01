package sbarrido.reimbursement.repository.expense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import sbarrido.reimbursement.model.expense.OtherExp;
import java.util.List;

public interface OtherExpRepository extends CrudRepository<OtherExp, Long> {

    @Query("select o from OtherExp o where year(o.date) = :year and month(o.date) = :month")
    List<OtherExp> findByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);
    OtherExp findByVendor(String vendor);
}