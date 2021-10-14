package sbarrido.reimbursement.service;

import org.springframework.stereotype.Service;

import sbarrido.reimbursement.repository.expense.OtherExpRepository;
import sbarrido.reimbursement.model.expense.OtherExp;

import java.util.Set;
import java.util.HashSet;

@Service
public class OtherExpService {
    private OtherExpRepository oRepository;

    public OtherExpService(OtherExpRepository repo) {
        this.oRepository = repo;
    }

    public Set<OtherExp> getAllOtherExp() {
        Set<OtherExp> target = (HashSet<OtherExp>) oRepository.findAll();

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