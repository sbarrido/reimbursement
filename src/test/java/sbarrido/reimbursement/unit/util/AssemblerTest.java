package sbarrido.reimbursement.unit.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

import static org.assertj.core.api.Assertions.*;

import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.util.assembler.*;

@TestComponent
public class AssemblerTest {

    private DestinationAssembler dAssembler;
    private Destination entity;
    private DestinationDto dto;

    public AssemblerTest() {
        dAssembler = new DestinationAssembler();
        initialize();
    }

    private void initialize() {
        entity = new Destination();
        entity.setDestination("Fort_Wayne");
        entity.setDistance(15.0);

        dto = new DestinationDto();
        dto.setId(entity.getId());
        dto.setDestination(entity.getDestination());
        dto.setDistance(entity.getDistance());
    }
    @Test
    public void toModelTest() {
        DestinationDto target = dAssembler.toModel(entity);

        assertThat(target.getId()).isEqualTo(dto.getId());
        assertThat(target.getDestination()).isEqualTo(dto.getDestination());
        assertThat(target.getDistance()).isEqualTo(dto.getDistance());

        System.out.println(target);
        System.out.println(target.getLinks());
        System.out.println(target.getDestination());
    }
}