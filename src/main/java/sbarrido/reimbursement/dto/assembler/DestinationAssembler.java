package sbarrido.reimbursement.dto.assembler;

import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.model.destination.Destination;

public class DestinationAssembler { 

    public DestinationAssembler() {}
    
    public DestinationDto toDto(Destination dest) {
        DestinationDto dto = new DestinationDto();
        dto.setDest(dest.getDest());
        dto.setDist(dest.getDist());

        return dto;
    }
    
    public Destination toEntity(DestinationDto dto) {
        Destination destination = new Destination();
        destination.setDest(dto.getDest());
        destination.setDist(dto.getDist());

        return destination;
    }
}