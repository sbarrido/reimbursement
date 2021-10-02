package sbarrido.reimbursement.controller;

import org.springframework.hateoas.CollectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.dto.assembler.DestinationAssembler;
import sbarrido.reimbursement.service.DestinationService;
import sbarrido.reimbursement.model.destination.Destination;

import java.util.Set;

@RestController
public class DestinationController {
    
    @Autowired
    private DestinationService destinationService;

    @Autowired
    private DestinationAssembler destinationAssembler;

    @GetMapping(value = "/{location}", produces = "application/hal+json")
    public DestinationDto getDestinationByLocation(@PathVariable String location) {
        Destination destination = destinationService.getDestination(location);
        
        return destinationAssembler.toModel(destination);
    }

    @GetMapping(value = "", produces = "application/hal+json")
    public CollectionModel<DestinationDto> getAllDestination() {
        Set<Destination> destinationList = destinationService.getAllDestination();

        return destinationAssembler.toCollectionModel(destinationList);
    }

}