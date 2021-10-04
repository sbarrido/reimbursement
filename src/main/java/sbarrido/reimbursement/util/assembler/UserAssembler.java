package sbarrido.reimbursement.dto.assembler;

import sbarrido.reimbursement.model.user.User;
import sbarrido.reimbursement.model.user.Role;
import sbarrido.reimbursement.dto.model.UserPostDto;
import sbarrido.reimbursement.dto.model.UserGetDto;
import java.util.Set;
import java.util.HashSet;

public class UserAssembler { 

    public UserAssembler() {}

    public UserPostDto toPostDto(User user) {
        UserPostDto dto = new UserPostDto();
        dto.setId(user.getId());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());

        Set<String> roles = new HashSet<>();
        for(Role role : user.getRoles()) {
            roles.add(role.getRole());
        }

        return dto;
    }
    public UserGetDto toGetDto(User user) {
        UserGetDto dto = new UserGetDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        Set<String> roles = new HashSet<>();
        for(Role role : user.getRoles()) {
            roles.add(role.getRole());
        }
        dto.setRoles(roles);

            return dto;
    }
    
    public User toEntity(UserPostDto userPostDto) {
        User user = new User();
        user.setUsername(userPostDto.getUsername());
        user.setPassword(userPostDto.getPassword());

        Set<Role> roles = new HashSet<>();
        for(String val : userPostDto.getRoles()) {
            Role role = new Role();
            role.setRole(val);
            roles.add(role);
        }
        return user;
    }
    public User toEntity(UserGetDto userGetDto) {
        User user = new User();
        user.setUsername(userGetDto.getUsername());

        Set<Role> roles = new HashSet<>();
        for(String val : userGetDto.getRoles()) {
            Role role = new Role();
            role.setRole(val);
            roles.add(role);
        }
        return user;
    }
}