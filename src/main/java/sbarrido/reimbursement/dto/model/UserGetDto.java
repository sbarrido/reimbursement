package sbarrido.reimbursement.dto.model;

import java.util.Set;

public class UserGetDto {

    private String id;
    private String username;
    private Set<String> roles;

    public UserGetDto() {}

    public String getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public Set<String> getRoles() {
        return this.roles;
    }

    public void setId(String val) {
        this.id = val;
    }
    public void setUsername(String val) {
        this.username = val;
    }
    public void setRoles(Set<String> vals) {
        this.roles = vals;
    }
}