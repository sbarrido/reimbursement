package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbarrido.reimbursement.repository.destination.DestinationRepository;
import sbarrido.reimbursement.model.destination.Destination;

import java.util.Set;
import java.util.HashSet;

@Service
public class DestinationService {
    private DestinationRepository dRepository;

    public DestinationService(DestinationRepository repo) {
        this.dRepository = repo;
    }

    public Set<Destination> getAllDestination() {
        Set<Destination> target = (HashSet<Destination>) dRepository.findAll();

        return target;
    }
    public Destination getDestination(Destination destination) {
        Destination target = dRepository.findByLocation(destination.getDest());
            
        return target;
    }
    public Destination createDestination(Destination destination) {
        return dRepository.save(destination);
    }
    
    @Transactional
    public Destination updateDestination(Destination destination) {
        Destination target = null;
        if(dRepository.existsById(destination.getId())) {
            target = dRepository.findById(destination.getId()).get();
            target.setDest(destination.getDest());
            target.setDist(destination.getDist());
            
            dRepository.save(target);
        }

        
        return target;
    }
    public void deleteDestination(Destination destination) {
        dRepository.delete(destination);
    }
}