package sbarrido.reimbursement.util.assembler;

import sbarrido.reimbursement.controller.OtherExpController;
import sbarrido.reimbursement.model.expense.OtherExp;
import sbarrido.reimbursement.dto.model.OtherExpDto;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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

        return dto;
    }
}