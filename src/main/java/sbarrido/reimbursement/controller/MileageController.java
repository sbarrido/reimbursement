package sbarrido.reimbursement.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sbarrido.reimbursement.dto.model.MileageDto;
import sbarrido.reimbursement.model.expense.Mileage;
import sbarrido.reimbursement.service.MileageService;
import sbarrido.reimbursement.util.assembler.MileageAssembler;

@RestController
public class MileageController {
    
    @Autowired
    private MileageService mileageService;

    @Autowired
    private MileageAssembler mileageAssembler;

    @GetMapping(value = "/mileages/{id}", produces = "application/hal+json")
    public MileageDto getMileageById(@PathVariable Long id) {
        Mileage mileage = mileageService.getMileage(id);

        return mileageAssembler.toModel(mileage);
    }

    @GetMapping(value = "/mileages", produces = "application/hal+json")
    public CollectionModel<MileageDto> getAllMileage() {
        Set<Mileage> mileageList = mileageService.getAllMileage();

        return mileageAssembler.toCollectionModel(mileageList);
    }
}