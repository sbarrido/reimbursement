package sbarrido.reimbursement.util.assembler;

import sbarrido.reimbursement.controller.OtherExpController;
import sbarrido.reimbursement.model.expense.OtherExp;
import sbarrido.reimbursement.dto.model.OtherExpDto;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.annotation.ManagedBean;

@ManagedBean
public class OtherExpAssembler extends RepresentationModelAssemblerSupport<OtherExp, OtherExpDto> {

    public OtherExpAssembler() {
        super(OtherExpController.class, OtherExpDto.class);
    }

    @Override
    public OtherExpDto toModel(OtherExp entity) {
        OtherExpDto dto = instantiateModel(entity);
        dto.setDate(entity.getDate());
        dto.setDescription(entity.getDesc());
        dto.setCost(entity.getCost());
        dto.setVendor(entity.getVendor());
        dto.setReceiptPath(entity.getImgPath());

        Link selfLink = linkTo(methodOn(OtherExpController.class)
                            .getOtherExpById(entity.getId()))
                            .withSelfRel();
        dto.add(selfLink);

        return dto;
    }
    @Override
    public CollectionModel<OtherExpDto> toCollectionModel(Iterable<? extends OtherExp> entities) {
        CollectionModel<OtherExpDto> dtos = super.toCollectionModel(entities);

        dtos.add(
            linkTo(methodOn(OtherExpController.class)
                .getAllOtherExp())
                .withSelfRel()
        );

        return dtos;
    }
    public OtherExp toEntity(OtherExpDto dto) {
        OtherExp target = new OtherExp();
        target.setId(dto.getId());
        target.setDescription(dto.getDescription());
        target.setDate(dto.getDate());
        target.setCost(dto.getCost());
        target.setImagePath(dto.getReceiptPath());
        target.setVendor(dto.getVendor());
        
        return target;
    }
}