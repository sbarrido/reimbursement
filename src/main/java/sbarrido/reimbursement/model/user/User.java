package sbarrido.reimbursement.model.user;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @OneToMany
    private List<Role> roles;

    public User() {}

    public User(String name, String password) {
        setUsername(name);
        setPassword(password);
    }

    public Long getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public List<Role> getRoles() {
        return this.roles;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String val) {
        this.username = val;
    }
    public void setPassword(String val) {
        this.password = val;
    }
    public void setRoles(List<Role> vals) {
        this.roles = vals;
    }
}