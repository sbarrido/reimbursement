package sbarrido.reimbursement.model.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue
    private String id;

    private String username;

    private String password;

    @OneToMany
    private Set<Role> roles;

    public User() {}

    public User(String name, String password) {

    }

    public String getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setUsername(String val) {
        this.username = val;
    }
    public void setPasswrd(String val) {
        this.password = val;
    }
    public void setRoles(Set<Role> vals) {
        this.roles = vals;
    }
}