package sbarrido.reimbursement.dto.assembler;

import sbarrido.reimbursement.model.expense.OtherExp;
import sbarrido.reimbursement.dto.model.OtherExpDto;

public class OtherExpAssembler {

    public OtherExpAssembler() {}

    public OtherExpDto toDto(OtherExp otherExp) {
        OtherExpDto dto = new OtherExpDto();
        dto.setDate(otherExp.getDate());
        dto.setDesc(otherExp.getDesc());
        dto.setCost(otherExp.getCost());
        dto.setVendor(otherExp.getVendor());
        dto.setReceiptPath(otherExp.getImgPath());

        return dto;
    }
    
    public OtherExp toEntity(OtherExpDto dto) {
        OtherExp otherExp = new OtherExp();
        otherExp.setDate(dto.getDate());
        otherExp.setDesc(dto.getDesc());
        otherExp.setCost(dto.getCost());
        otherExp.setVendor(dto.getVendor());
        otherExp.setImagePath(dto.getReceiptPath());

        return otherExp;
    }
}