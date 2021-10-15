package sbarrido.reimbursement.util.assembler;

import sbarrido.reimbursement.model.user.User;
import sbarrido.reimbursement.dto.model.UserDto;
import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.controller.UserController;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Set;
import java.util.HashSet;

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
        dto.setRoles(toStringRoles(entity.getRoles()));

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
    private Set<String> toStringRoles(Set<Role> set) {
        Set<String> target = new HashSet<String>();
        for(Role role : set) {
            target.add(role.getRole());
        }
        return target;
    }
}