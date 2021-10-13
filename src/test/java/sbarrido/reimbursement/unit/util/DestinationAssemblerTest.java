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
    }
    @Test
    public void toCollectionTest() {
        CollectionModel<DestinationDto> target = dAssembler.toCollectionModel(list);
        
        System.out.println(target);
    }
}
