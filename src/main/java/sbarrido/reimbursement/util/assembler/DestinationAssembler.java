package sbarrido.reimbursement.util.assembler;


import sbarrido.reimbursement.controller.DestinationController;
import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.dto.model.DestinationDto;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.annotation.ManagedBean;


@ManagedBean
public class DestinationAssembler extends RepresentationModelAssemblerSupport<Destination, DestinationDto> { 

    public DestinationAssembler() {
        super(DestinationController.class, DestinationDto.class);
    }

    @Override
    public DestinationDto toModel(Destination entity) {
        DestinationDto dto = instantiateModel(entity);
        dto.setDestination(entity.getDestination());
        dto.setDistance(entity.getDistance());
        dto.setId(entity.getId());

        Link selfLink = linkTo(methodOn(DestinationController.class)
                            .getDestinationByLocation(entity.getDestination()))
                            .withSelfRel();
        dto.add(selfLink);

        return dto;
    }
    @Override
    public CollectionModel<DestinationDto> toCollectionModel(Iterable<? extends Destination> entities) {
        CollectionModel<DestinationDto> dtos = super.toCollectionModel(entities);

        dtos.add(
            linkTo(methodOn(DestinationController.class)
                .getAllDestination())
                .withSelfRel()
        );
        
        return dtos;
    }
}