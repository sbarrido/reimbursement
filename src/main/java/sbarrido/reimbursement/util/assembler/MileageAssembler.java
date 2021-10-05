package sbarrido.reimbursement.util.assembler;

import sbarrido.reimbursement.controller.MileageController;
import sbarrido.reimbursement.dto.model.MileageDto;
import sbarrido.reimbursement.model.expense.Mileage;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class MileageAssembler extends RepresentationModelAssemblerSupport<Mileage, MileageDto> {
    private DestinationAssembler destinationAssembler;

    public MileageAssembler(DestinationAssembler assembler) {
        super(MileageController.class, MileageDto.class);
        this.destinationAssembler = assembler;
    }

    @Override
    public MileageDto toModel(Mileage entity) {
       MileageDto dto = instantiateModel(entity);
       dto.setDate(entity.getDate());
       dto.setDescription(entity.getDesc());
       dto.setId(entity.getId());
       dto.setCost(entity.getCost());
       dto.setDest(
            destinationAssembler.toModel(entity.getDest())              
       );

       return dto;
    }
}