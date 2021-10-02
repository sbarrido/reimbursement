package sbarrido.reimbursement.dto.assembler;


import sbarrido.reimbursement.controller.DestinationController;
import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.model.destination.Destination;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.Link;

public class DestinationAssembler implements RepresentationModelAssembler<Destination, DestinationDto>{ 
    private WebMvcLinkBuilder linkBuilder;
    public DestinationAssembler() {}

    @Override
    public DestinationDto toModel(Destination entity) {
        DestinationDto dto = new DestinationDto();
        dto.setDest(entity.getDest());
        dto.setDist(entity.getDist());
        dto.setId(entity.getId());

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DestinationController.class).getDestinationByLocation(entity.getDest())).withSelfRel();
        dto.add(selfLink);
        
        return dto;
    }
    @Override
    public CollectionModel<DestinationDto> toCollectionModel(Iterable<? extends Destination> destinationList) {
        //TODO
        return null;
    }
}