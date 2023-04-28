//package sbarrido.reimbursement.util.assembler;
//
//import javax.annotation.ManagedBean;
//
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
//
//import sbarrido.reimbursement.controller.RoleController;
//import sbarrido.reimbursement.dto.model.RoleDto;
//import sbarrido.reimbursement.model.user.Role;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//
//@ManagedBean
//public class RoleAssembler extends RepresentationModelAssemblerSupport<Role, RoleDto> {
//
//    public RoleAssembler() {
//        super(RoleController.class, RoleDto.class);
//    }
//    @Override
//    public RoleDto toModel(Role entity) {
//        RoleDto dto = instantiateModel(entity);
//        dto.setId(entity.getId());
//        dto.setRole(entity.getRole());
//
//        Link selfLink = linkTo(methodOn(RoleController.class)
//                            .getRoleById(entity.getId()))
//                            .withSelfRel();
//        dto.add(selfLink);
//
//        return dto;
//    }
//    @Override
//    public CollectionModel<RoleDto> toCollectionModel(Iterable<? extends Role> entities) {
//        CollectionModel<RoleDto> dtos = super.toCollectionModel(entities);
//
//        dtos.add(
//            linkTo(methodOn(RoleController.class)
//                .getAllRole())
//                .withSelfRel()
//        );
//
//        return dtos;
//    }
//    public Role toEntity(RoleDto dto) {
//        Role target = new Role();
//        target.setId(dto.getId());
//        target.setRole(dto.getRole());
//
//        return target;
//    }
//}