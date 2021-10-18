package sbarrido.reimbursement.dto.model;


public class MileageDto extends ReimbursementDto { 
    private DestinationDto destDto;

    public MileageDto() {}

    public DestinationDto getDestination() {
        return this.destDto;
    }

    public void setDestination(DestinationDto dto) {
        this.destDto = dto;
    }

}