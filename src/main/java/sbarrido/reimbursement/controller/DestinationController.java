package sbarrido.reimbursement.controller;

import org.springframework.hateoas.CollectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.service.DestinationService;
import sbarrido.reimbursement.util.assembler.DestinationAssembler;

import java.util.ArrayList;

@RestController
@CrossOrigin()
public class DestinationController {
    
    @Autowired
    private DestinationService destinationService;

    @Autowired
    private DestinationAssembler destinationAssembler;

    @GetMapping(value = "/destinations/{location}", produces = "application/json")
    public DestinationDto getDestinationByLocation(@PathVariable String location) {
        Destination destination = destinationService.getDestination(location);
        
        return destinationAssembler.toModel(destination);
    }
    @GetMapping(value = "/destinations", produces = "application/json")
    public CollectionModel<DestinationDto> getAllDestination() {
        ArrayList<Destination> destinationList = destinationService.getAllDestination();

        return destinationAssembler.toCollectionModel(destinationList);
    }
    @PostMapping(value = "/destinations", consumes = "application/json") 
    public Destination create(@RequestBody DestinationDto destinationDTO) {
        Destination target = destinationAssembler.toEntity(destinationDTO);
        target = destinationService.createDestination(target);
        
        return target;
    }
//    @DeleteMapping(value= "/destinations/{location}")
//    public void delete(@PathVariable String location) {
//        Destination target = destinationService.getDestination(location);
//        destinationService.deleteDestination(target);
//    }
}