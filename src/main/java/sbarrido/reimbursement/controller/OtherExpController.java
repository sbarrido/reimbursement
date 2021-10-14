package sbarrido.reimbursement.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sbarrido.reimbursement.dto.model.OtherExpDto;
import sbarrido.reimbursement.model.expense.OtherExp;
import sbarrido.reimbursement.service.OtherExpService;
import sbarrido.reimbursement.util.assembler.OtherExpAssembler;

@RestController
public class OtherExpController { 
    
    @Autowired
    private OtherExpService otherExpService;

    @Autowired
    private OtherExpAssembler otherExpAssembler;

   @GetMapping(value = "/other_expenses/{id}", produces = "application/hal+json")
   public OtherExpDto getOtherExpById(@PathVariable Long id) {
       OtherExp otherExp = otherExpService.getOtherExp(id);

       return otherExpAssembler.toModel(otherExp);
   }
   @GetMapping(value = "/other_expenses", produces = "application/hal+json")
   public CollectionModel<OtherExpDto> getAllOtherExp() {
       Set<OtherExp> otherExpList = otherExpService.getAllOtherExp();

       return otherExpAssembler.toCollectionModel(otherExpList);
   }
}