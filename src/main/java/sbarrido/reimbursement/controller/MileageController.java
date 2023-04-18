package sbarrido.reimbursement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbarrido.reimbursement.dto.model.MileageDto;
import sbarrido.reimbursement.model.expense.Mileage;
import sbarrido.reimbursement.service.MileageService;
import sbarrido.reimbursement.util.assembler.MileageAssembler;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MileageController {
    
    @Autowired
    private MileageService mileageService;

    @Autowired
    private MileageAssembler mileageAssembler;

    @GetMapping(value = "/mileages/{id}", produces = "application/json")
    public MileageDto getMileageById(@PathVariable Long id) {
        Mileage mileage = mileageService.getMileage(id);

        return mileageAssembler.toModel(mileage);
    }
    @GetMapping(value = "/mileages", produces = "application/json")
    public CollectionModel<MileageDto> getAllMileage() {
        List<Mileage> mileageList = mileageService.getAllMileage();

        return mileageAssembler.toCollectionModel(mileageList);
    }
    @GetMapping(value = "/mileages/date", produces = "application/json")
    public CollectionModel<MileageDto> getAllMileage(@RequestParam("date") String stringDate) {
        LocalDate localDate = LocalDate.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE);
        List<Mileage> mileageList = mileageService.getMileageByDate(localDate);

        return mileageAssembler.toCollectionModel(mileageList);
    }
    @PostMapping(value = "/mileages", produces = "application/json")
    public Mileage create(@RequestBody MileageDto mileageDTO) {
        Mileage target = mileageAssembler.toEntity(mileageDTO);
        target = mileageService.createMileage(target);

        return target;
    }
    @DeleteMapping(value = "/mileages/{id}")
    public void delete(@PathVariable Long id) {
        Mileage target = mileageService.getMileage(id);
        target.setDestination(null);
        mileageService.deleteMileage(target);
    }
}