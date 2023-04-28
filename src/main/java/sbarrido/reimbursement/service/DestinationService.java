package sbarrido.reimbursement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbarrido.reimbursement.model.expense.Mileage;
import sbarrido.reimbursement.repository.destination.DestinationRepository;
import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.repository.expense.MileageRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DestinationService {
    private DestinationRepository dRepository;
    private MileageRepository mRepository;

    public DestinationService(DestinationRepository repo, MileageRepository mRepo) {
        this.dRepository = repo;
        this.mRepository = mRepo;
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

//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional
//    public void deleteDestination(Destination destination) {
//        List<Mileage> mileageList = mRepository.findAllByDestination(destination);
//        for (Mileage i: mileageList) {
//            entityManager.remove(i);
//        }
//        entityManager.remove(destination);
//    }
}