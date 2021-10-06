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
        entity.setDest("Fort_Wayne");
        entity.setDist(15.0);

        dto = new DestinationDto();
        dto.setId(entity.getId());
        dto.setDest(entity.getDest());
        dto.setDist(entity.getDist());
    }
    @Test
    public void toModelTest() {
        DestinationDto target = dAssembler.toModel(entity);

        assertThat(target.getId()).isEqualTo(dto.getId());
        assertThat(target.getDest()).isEqualTo(dto.getDest());
        assertThat(target.getDist()).isEqualTo(dto.getDist());

        System.out.println(target);
        System.out.println(target.getLinks());
        System.out.println(target.getDest());
    }
}