package sbarrido.reimbursement.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

   @GetMapping(value = "/other_expenses/{id}", produces = "application/json")
   public OtherExpDto getOtherExpById(@PathVariable Long id) {
       OtherExp otherExp = otherExpService.getOtherExp(id);

       return otherExpAssembler.toModel(otherExp);
   }
   @GetMapping(value = "/other_expenses", produces = "application/json")
   public CollectionModel<OtherExpDto> getAllOtherExp() {
       List<OtherExp> otherExpList = otherExpService.getAllOtherExp();

       return otherExpAssembler.toCollectionModel(otherExpList);
   }
   @GetMapping(value = "/other_expenses/date", produces = "application/json")
   public CollectionModel<OtherExpDto> getAllOtherExp(@RequestParam("date") String stringDate) {
       LocalDate localDate = LocalDate.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE);
       List<OtherExp> otherExpList = otherExpService.getOtherExpByDate(localDate);

       return otherExpAssembler.toCollectionModel(otherExpList);
   }
   @PostMapping(value = "/other_expenses", produces = "appliaction/json") 
   public OtherExp create(@RequestBody OtherExpDto otherExpDTO) {
       OtherExp target = otherExpAssembler.toEntity(otherExpDTO);
       otherExpService.createOtherExp(target);

       return target;
   }
   @DeleteMapping(value = "/other_expenses/{id}")
   public OtherExp delete(@PathVariable Long id) {
       OtherExp target = otherExpService.getOtherExp(id);
       otherExpService.deleteOtherExp(target);

       return target;
   }
}