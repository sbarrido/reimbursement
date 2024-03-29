package sbarrido.reimbursement.util.assembler;

import sbarrido.reimbursement.controller.MileageController;
import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.dto.model.MileageDto;
import sbarrido.reimbursement.model.expense.Mileage;
import sbarrido.reimbursement.service.DestinationService;
import sbarrido.reimbursement.model.destination.Destination;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;

@ManagedBean
public class MileageAssembler extends RepresentationModelAssemblerSupport<Mileage, MileageDto> {

    @Autowired
    DestinationService dService;
    
    public MileageAssembler() {
        super(MileageController.class, MileageDto.class);
    }

    @Override
    public MileageDto toModel(Mileage entity) {
       MileageDto dto = instantiateModel(entity);
       dto.setDate(entity.getDate());
       dto.setDescription(entity.getDesc());
       dto.setId(entity.getId());
       dto.setCost(entity.getCost());
       dto.setDestination(
            this.toDestModel(entity.getDestination())             
       );

       Link selfLink = linkTo(methodOn(MileageController.class)
                            .getMileageById(entity.getId()))
                            .withSelfRel();
        dto.add(selfLink);

       return dto;
    }

    @Override
    public CollectionModel<MileageDto> toCollectionModel(Iterable<? extends Mileage> entities) {
        CollectionModel<MileageDto> dtos = super.toCollectionModel(entities);

        dtos.add(
            linkTo(methodOn(MileageController.class)
            .getAllMileage())
            .withSelfRel()
        );

        return dtos;
    }
    public Mileage toEntity(MileageDto dto) {
        Mileage target = new Mileage();
        target.setId(dto.getId());
        target.setDate(dto.getDate());
        target.setDescription(dto.getDescription());
        target.setCost(dto.getCost());
        target.setDestination(this.toDest(dto.getDestination()));

        return target;
    }
    private DestinationDto toDestModel(Destination entity) {
        DestinationDto dto = new DestinationDto();
        dto.setId(entity.getId());
        dto.setDestination(entity.getDestination());
        dto.setDistance(entity.getDistance());

        return dto;
    }
    private Destination toDest(DestinationDto dto) {
        Destination target = dService.getDestination(dto.getDestination());

        return target;
    }
}