package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbarrido.reimbursement.repository.expense.MileageRepository;
import sbarrido.reimbursement.model.expense.Mileage;

import java.util.Set;
import java.util.HashSet;

@Service
public class MileageService {
    private MileageRepository mRepository;

    public MileageService(MileageRepository repo) {
        this.mRepository = repo;
    }
    
    public Set<Mileage> getAllMileage() {
        Set<Mileage> target = (HashSet<Mileage>) mRepository.findAll();

        return target;
    }
    public Mileage getMileage(Mileage mileage) {
        Mileage target = mRepository.findById(mileage.getId()).get();

        return target;
    }
    public Mileage createMileage(Mileage mileage) {
        Mileage target = null;
        if(!mRepository.existsById(mileage.getId())) {
            target = mRepository.save(mileage);
        }

        return target;
    }
    public Mileage updateMileage(Mileage mileage) {
        Mileage target = null;
        if(mRepository.existsById(mileage.getId())) {
            target = mRepository.findById(mileage.getId()).get();
            target.setDate(mileage.getDate());
            target.setDesc(mileage.getDesc());
            target.setDest(mileage.getDest());
            target.setCost(mileage.getCost());

            target = mRepository.save(target);
        }

        return target;
    }
    public void deleteMileage(Mileage mileage) {
        mRepository.delete(mileage);
    }
}