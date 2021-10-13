package sbarrido.reimbursement.dto.model;


public class MileageDto extends ReimbursementDto { 
    private DestinationDto destDto;

    public MileageDto() {}

    public DestinationDto getDest() {
        return this.destDto;
    }

    public void setDest(DestinationDto dto) {
        this.destDto = dto;
    }

}