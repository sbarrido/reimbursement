package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;

import sbarrido.reimbursement.repository.expense.MileageRepository;
import sbarrido.reimbursement.model.expense.Mileage;

import java.time.LocalDate;
import java.util.List;

@Service
public class MileageService {
    private MileageRepository mRepository;

    public MileageService(MileageRepository repo) {
        this.mRepository = repo;
    }
    
    public List<Mileage> getAllMileage() {
        List<Mileage> target = (List<Mileage>) mRepository.findAll();

        return target;
    }
    public Mileage getMileage(Long id) {
        Mileage target = mRepository.findById(id).get();

        return target;
    }
    public Mileage getMileage(Mileage mileage) {
        Mileage target = getMileage(mileage.getId());

        return target;
    }
    public List<Mileage> getMileageByDate(LocalDate localDate) {
        int month = localDate.getMonthValue();
        int year = localDate.getYear();

        List<Mileage> target = mRepository.findByYearAndMonth(year, month);

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