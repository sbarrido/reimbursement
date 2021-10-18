package sbarrido.reimbursement.unit.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.hateoas.CollectionModel;

import static org.assertj.core.api.Assertions.*;

import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.dto.model.DestinationDto;
import sbarrido.reimbursement.util.assembler.*;

import java.util.List;
import java.util.ArrayList;

@TestComponent
public class DestinationAssemblerTest {

    private DestinationAssembler dAssembler;
    private Destination entity;
    private DestinationDto dto;
    private ArrayList<Destination> list;
    
    public DestinationAssemblerTest() {
        dAssembler = new DestinationAssembler();
        initialize();
    }

    private void initialize() {
        list = new ArrayList<>(
            List.of(
                new Destination("Paris", 53.6),
                new Destination("Chicago", 14.2),
                new Destination("London", 152.5)
            )
        );

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
    }
    @Test
    public void toCollectionTest() {
        CollectionModel<DestinationDto> target = dAssembler.toCollectionModel(list);
        
        System.out.println(target);
    }
}
