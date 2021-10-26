package sbarrido.reimbursement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);

        return userAssembler.toModel(user);
    }
    @GetMapping(value = "/users", produces = "application/json")
    public CollectionModel<UserDto> getAllUser() {
        ArrayList<User> userList = userService.getAllUser();

        return userAssembler.toCollectionModel(userList);
    }
    @PostMapping(path = "/users", consumes = "application/json")
    public User create(@RequestBody UserDto userDTO) {
        User target = userAssembler.toEntity(userDTO);
        userService.createUser(target);

        return target;
    }
    @DeleteMapping(value = "/users/{id}")
    public User delete(@PathVariable Long id) {
        User target = userService.getUser(id);
        userService.deleteUser(target);

        return target;
    }
}