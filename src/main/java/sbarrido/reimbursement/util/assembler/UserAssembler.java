package sbarrido.reimbursement.util.assembler;

import sbarrido.reimbursement.model.user.User;
import sbarrido.reimbursement.model.user.UserRoles;
import sbarrido.reimbursement.dto.model.UserDto;
import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.controller.UserController;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.annotation.ManagedBean;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class UserAssembler extends RepresentationModelAssemblerSupport<User, UserDto> { 

    public UserAssembler() {
        super(UserController.class, UserDto.class);
    }

    @Override
    public UserDto toModel(User entity) {
        UserDto dto = instantiateModel(entity);
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRoles(toRoles(entity.getRoles()));

        Link selfLink = linkTo(methodOn(UserController.class)
                            .getUserById(entity.getId()))
                            .withSelfRel();
        dto.add(selfLink);

        return dto;
    }
    @Override
    public CollectionModel<UserDto> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserDto> dtos = super.toCollectionModel(entities);

        dtos.add(
            linkTo(methodOn(UserController.class)
                .getAllUser())
                .withSelfRel()
        );

        return dtos;
    }
    public User toEntity(UserDto dto) {
        User target = new User();
        target.setId(dto.getId());
        target.setUsername(dto.getUsername());
        target.setPassword(dto.getPassword());
        
        
        return target;
    }
    private List<Enum<UserRoles>> toRoles(List<Role> list) {
        List<Enum<UserRoles>> target = new ArrayList<>();
        for(Role role : list) {
            target.add(role.getRole());
        }
        return target;
    }
}