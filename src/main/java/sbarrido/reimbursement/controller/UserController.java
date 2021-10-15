package sbarrido.reimbursement.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sbarrido.reimbursement.dto.model.UserDto;
import sbarrido.reimbursement.model.user.User;
import sbarrido.reimbursement.service.UserService;
import sbarrido.reimbursement.util.assembler.UserAssembler;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

    @GetMapping(value = "/users/{id}", produces = "application/hal+json")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);

        return userAssembler.toModel(user);
    }
    @GetMapping(value = "/users", produces = "application/hal+json")
    public CollectionModel<UserDto> getAllUser() {
        Set<User> userList = userService.getAllUser();

        return userAssembler.toCollectionModel(userList);
    }
}