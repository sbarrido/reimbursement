package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbarrido.reimbursement.repository.destination.DestinationRepository;
import sbarrido.reimbursement.model.destination.Destination;

import java.util.ArrayList;

@Service
public class DestinationService {
    private DestinationRepository dRepository;

    public DestinationService(DestinationRepository repo) {
        this.dRepository = repo;
    }

    public ArrayList<Destination> getAllDestination() {
        ArrayList<Destination> target = (ArrayList<Destination>) dRepository.findAll();

        return target;
    }
    public Destination getDestination(Destination destination) {
        Destination target = dRepository.findById(destination.getId()).get();
            
        return target;
    }
    public Destination getDestination(String location) {
        Destination target = dRepository.findByLocation(location);

        return target;
    }
    public Destination createDestination(Destination destination) {
        Destination target = null;
        if(!dRepository.existsById(destination.getId())) {   
            target = dRepository.save(destination);
        }
        return target;
    }
    
    @Transactional
    public Destination updateDestination(Destination destination) {
        Destination target = null;
        if(dRepository.existsById(destination.getId())) {
            target = dRepository.findById(destination.getId()).get();
            target.setDestination(destination.getDestination());
            target.setDistance(destination.getDistance());
            
            dRepository.save(target);
        }

        
        return target;
    }
    public void deleteDestination(Destination destination) {
        dRepository.delete(destination);
    }
}