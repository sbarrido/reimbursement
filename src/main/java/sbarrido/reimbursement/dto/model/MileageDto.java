package sbarrido.reimbursement.dto.model;

import java.util.Date;

public class MileageDto extends ReimburseemntDto { 
    private DestinationDto destDto;

    public MileageDto() {}

    public DestinationDto getDest() {
        return this.destDto;
    }

    public void setDest(DestinationDto dto) {
        this.destDto = dto;
    }

}