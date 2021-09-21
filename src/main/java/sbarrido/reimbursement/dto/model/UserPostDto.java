package sbarrido.reimbursement.dto.model;

import java.util.Set;

public class UserPostDto {

    private String id;
    private String username;
    private String password;
    private Set<String> roles;

    public UserPostDto() {}

    public String getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
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
    public void setPassword(String val) {
        this.password = val;
    }
    public void setRoles(Set<String> vals) {
        this.roles = vals;
    }
}