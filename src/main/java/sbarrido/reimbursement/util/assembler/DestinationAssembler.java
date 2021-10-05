package sbarrido.reimbursement.util.assembler;


import sbarrido.reimbursement.controller.DestinationController;
import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.dto.model.DestinationDto;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class DestinationAssembler extends RepresentationModelAssemblerSupport<Destination, DestinationDto> { 

    public DestinationAssembler() {
        super(DestinationController.class, DestinationDto.class);
    }

    @Override
    public DestinationDto toModel(Destination entity) {
        DestinationDto dto = instantiateModel(entity);
        dto.setDest(entity.getDest());
        dto.setDist(entity.getDist());
        dto.setId(entity.getId());

        Link selfLink = linkTo(methodOn(DestinationController.class)
                            .getDestinationByLocation(entity.getDest()))
                            .withSelfRel();
        dto.add(selfLink);

        return dto;
    }
}