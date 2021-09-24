package sbarrido.reimbursement.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbarrido.reimbursement.repository.expense.OtherExpRepository;
import sbarrido.reimbursement.model.expense.OtherExp;

import java.util.Set;
import java.util.HashSet;

public class OtherExpService {
    private OtherExpRepository oRepository;

    public OtherExpService(OtherExpRepository repo) {
        this.oRepository = repo;
    }

    public Set<OtherExp> getAllOtherExp() {
        Set<OtherExp> target = (HashSet<OtherExp>) oRepository.findAll();

        return target;
    }
    public OtherExp getOtherExp(OtherExp otherExp) {
        OtherExp target = oRepository.findById(otherExp.getId()).get();

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