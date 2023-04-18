package sbarrido.reimbursement.repository.expense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.model.expense.Mileage;

import java.util.List;

public interface MileageRepository extends CrudRepository<Mileage, Long> {

   @Query("select m from Mileage m where year(m.date) = :year and month(m.date) = :month")
   List<Mileage> findByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);
   Mileage findByDestination(Destination dest);

   @Query("SELECT m FROM Mileage m WHERE m.destination = :destination")
   List<Mileage> findAllByDestination(@Param("destination") Destination destination);
}