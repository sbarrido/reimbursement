package sbarrido.reimbursement.repository.destination;

import org.springframework.data.repository.CrudRepository;
import sbarrido.reimbursement.model.destination.Destination;

public interface DestinationRepository extends CrudRepository<Destination, Long> {
    
    Destination findByLocation(String location);
}