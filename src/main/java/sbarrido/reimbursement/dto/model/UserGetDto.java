package sbarrido.reimbursement.dto.model;

import java.util.Set;

public class UserGetDto {

    private Long id;
    private String username;
    private Set<String> roles;

    public UserGetDto() {}

    public Long getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public Set<String> getRoles() {
        return this.roles;
    }

    public void setId(Long val) {
        this.id = val;
    }
    public void setUsername(String val) {
        this.username = val;
    }
    public void setRoles(Set<String> vals) {
        this.roles = vals;
    }
}