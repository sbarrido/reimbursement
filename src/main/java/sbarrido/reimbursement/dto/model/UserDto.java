package sbarrido.reimbursement.dto.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import sbarrido.reimbursement.model.user.UserRoles;

public class UserDto extends RepresentationModel<UserDto> {

    private Long id;
    private String username;
    private String password;
    private List<Enum<UserRoles>> roles;

    public UserDto() {}

    public Long getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public List<Enum<UserRoles>> getRoles() {
        return this.roles;
    }

    public void setId(Long val) {
        this.id = val;
    }
    public void setUsername(String val) {
        this.username = val;
    }
    public void setPassword(String val) {
        this.password = val;
    }
    public void setRoles(List<Enum<UserRoles>> vals) {
        this.roles = vals;
    }
}