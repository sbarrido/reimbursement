package sbarrido.reimbursement.dto.assembler;

import sbarrido.reimbursement.dto.model.MileageDto;
import sbarrido.reimbursement.model.expense.Mileage;

public class MileageAssembler {
    private DestinationAssembler destinationAssembler;

    public MileageAssembler(DestinationAssembler assembler) {
        this.destinationAssembler = assembler;
    }

    public MileageDto toDto(Mileage mileage) {
        MileageDto dto = new MileageDto();

        return dto;
    }
    /*
    public Mileage toEntity(MileageDto dto) {
        Mileage mileage = new Mileage();
        mileage.setCost(dto.getCost());
        mileage.setDate(dto.getDate());
        mileage.setDesc(dto.getDesc());
        

        return mileage;
    }
    */
}