package sbarrido.reimbursement.service;

import org.springframework.stereotype.Service;

import sbarrido.reimbursement.repository.expense.OtherExpRepository;
import sbarrido.reimbursement.model.expense.OtherExp;

import java.time.LocalDate;
import java.util.List;

@Service
public class OtherExpService {
    private OtherExpRepository oRepository;

    public OtherExpService(OtherExpRepository repo) {
        this.oRepository = repo;
    }

    public List<OtherExp> getAllOtherExp() {
       List<OtherExp> target = (List<OtherExp>) oRepository.findAll();

        return target;
    }
    public OtherExp getOtherExp(Long id) {
        OtherExp target = oRepository.findById(id).get();

        return target;
    }
    public OtherExp getOtherExp(OtherExp otherExp) {
        OtherExp target = getOtherExp(otherExp.getId());

        return target;
    }
    public List<OtherExp> getOtherExpByDate(LocalDate localDate) {
        int month = localDate.getMonthValue();
        int year = localDate.getYear();

        List<OtherExp> target = oRepository.findByYearAndMonth(year, month);
        
        return target;
    }
    public OtherExp createOtherExp(OtherExp otherExp) {
        OtherExp target = null;
        if(!oRepository.existsById(otherExp.getId())) {
            target = oRepository.save(otherExp);
        }

        return target;
    }
    public OtherExp updateOtherExp(OtherExp otherExp) {
        OtherExp target = null;
        if(oRepository.existsById(otherExp.getId())) {
            target = oRepository.findById(otherExp.getId()).get();
            target.setDate(otherExp.getDate());
            target.setDesc(otherExp.getDesc());
            target.setVendor(otherExp.getVendor());
            target.setImagePath(otherExp.getImgPath());
            target.setCost(otherExp.getCost());
            
            target = oRepository.save(target);
        }   

        return target;
    }
    public void deleteOtherExp(OtherExp otherExp) {
        oRepository.delete(otherExp);
    }
}